package com.myproject.repository;

import com.myproject.common.Constant;
import com.myproject.common.dto.BaseDTO;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.common.repository.BaseRepository;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.PetTypeDTO;
import com.myproject.data.entity.PetTypeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Repository
public class PetTypeRepositoryImpl extends BaseRepository implements PetTypeRepository {


    @Override
    public PetTypeDTO findPetTypeById(Long petTypeId) {
        PetTypeEntity petTypeEntity = getEntityManager().find(PetTypeEntity.class, petTypeId);
        PetTypeDTO petTypeDTO = petTypeEntity.toDto();
        return petTypeDTO;
    }

    @Override
    public ResultInsideDTO insertPetType(PetTypeDTO petTypeDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PetTypeEntity petTypeEntity = getEntityManager().merge(petTypeDTO.toEntity());
        resultInsideDTO.setId(petTypeEntity.getPetTypeId());
        return resultInsideDTO;
    }

    @Override
    public ResultInsideDTO updatePetTypeInfo(PetTypeDTO petTypeDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PetTypeEntity petTypeEntity = getEntityManager().find(PetTypeEntity.class, petTypeDTO.getPetTypeId());
        if (petTypeEntity != null) {
            petTypeEntity = getEntityManager().merge(petTypeDTO.toEntity());
            resultInsideDTO.setId(petTypeEntity.getPetTypeId());
        } else {
            resultInsideDTO.setKey(Constant.RESPONSE_KEY.RECORD_NOT_EXIST);
        }
        return resultInsideDTO;
    }

    @Override
    public ResultInsideDTO deletePetTypeById(Long petTypeId) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PetTypeEntity petTypeEntity = getEntityManager().find(PetTypeEntity.class, petTypeId);
        getEntityManager().remove(petTypeEntity);
        return resultInsideDTO;
    }

    @Override
    public Datatable getDatatablePetType(PetTypeDTO petTypeDTO) {
        BaseDTO baseDTO = sqlSearch(petTypeDTO);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(),
                baseDTO.getParameters(), petTypeDTO.getPage(), petTypeDTO.getPageSize(),
                PetTypeDTO.class,
                petTypeDTO.getSortName(), petTypeDTO.getSortType());
    }

    private BaseDTO sqlSearch(PetTypeDTO petTypeDTO) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("petType", "getDatatablePetType");
        if (petTypeDTO != null) {
            if (!DataUtil.isNullOrEmpty(petTypeDTO.getSearchAll())) {
                sql += " And lower(pt.tenloaivatnuoi) Like lower(:searchAll) ";
                parameter.put("searchAll", DataUtil.convertSqlLike(petTypeDTO.getSearchAll()));
            }
        }
        sql += " ORDER BY pt.tenloaivatnuoi ASC ";
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }
}
