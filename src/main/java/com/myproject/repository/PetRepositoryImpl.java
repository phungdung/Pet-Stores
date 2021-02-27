package com.myproject.repository;

import com.myproject.common.Constant;
import com.myproject.common.dto.BaseDTO;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.common.repository.BaseRepository;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.PetDTO;
import com.myproject.data.entity.PetEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class PetRepositoryImpl extends BaseRepository implements PetRepository {


    @Override
    public PetDTO findPetById(Long petId) {
        PetEntity petEntity = getEntityManager().find(PetEntity.class, petId);
        PetDTO petDTO = petEntity.toDto();
        return petDTO;
    }

    @Override
    public ResultInsideDTO insertPet(PetDTO petDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PetEntity petEntity = getEntityManager().merge(petDTO.toEntity());
        resultInsideDTO.setId(petEntity.getPetId());
        return resultInsideDTO;
    }

    @Override
    public ResultInsideDTO updatePetInfo(PetDTO petDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PetEntity petEntity = getEntityManager().find(PetEntity.class, petDTO.getPetId());
        if (petEntity != null) {
            petEntity = getEntityManager().merge(petDTO.toEntity());
            resultInsideDTO.setId(petEntity.getPetId());
        } else {
            resultInsideDTO.setKey(Constant.RESPONSE_KEY.RECORD_NOT_EXIST);
        }
        return resultInsideDTO;
    }

    @Override
    public ResultInsideDTO deletePetById(Long petId) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PetEntity petEntity = getEntityManager().find(PetEntity.class, petId);
        getEntityManager().remove(petEntity);
        return resultInsideDTO;
    }

    @Override
    public Datatable getDatatablePet(PetDTO petDTO) {
        BaseDTO baseDTO = sqlSearch(petDTO);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(),
                baseDTO.getParameters(), petDTO.getPage(), petDTO.getPageSize(),
                PetDTO.class,
                petDTO.getSortName(), petDTO.getSortType());
    }

    @Override
    public List<PetDTO> getListDataExport(PetDTO petDTO) {
        BaseDTO baseDTO = sqlSearch(petDTO);
        return getNamedParameterJdbcTemplate().query(baseDTO.getSqlQuery()
                , baseDTO.getParameters()
                , BeanPropertyRowMapper.newInstance(PetDTO.class));
    }

    private BaseDTO sqlSearch(PetDTO petDTO) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("pet", "getDatatablePet");
        if (petDTO != null) {
            if (!DataUtil.isNullOrEmpty(petDTO.getSearchAll())) {
                sql += " And lower(p.tenvatnuoi) Like lower(:searchAll) ";
                parameter.put("searchAll", DataUtil.convertSqlLike(petDTO.getSearchAll()));
            }
        }
        sql += " ORDER BY p.tenvatnuoi ASC ";
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }
}
