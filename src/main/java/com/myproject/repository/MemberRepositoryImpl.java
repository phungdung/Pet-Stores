package com.myproject.repository;

import com.myproject.common.Constant;
import com.myproject.common.dto.BaseDTO;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.common.repository.BaseRepository;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;
import com.myproject.data.entity.MemberEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Repository
public class MemberRepositoryImpl extends BaseRepository implements MemberRepository {


    @Override
    public MemberDTO findMemberById(Long userId) {
        MemberEntity memberEntity = getEntityManager().find(MemberEntity.class, userId);
        MemberDTO memberDTO = memberEntity.toDto();
        return memberDTO;
    }

    //    @Override
//    public ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO) {
//        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
//        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
//        EmployeeEntity employeeEntity = getEntityManager().merge(employeeDTO.toEntity());
//        resultInsideDTO.setId(employeeEntity.getEmployeeId());
//        return resultInsideDTO;
//    }
//
//    @Override
//    public ResultInsideDTO updateMemberInfo(MemberDTO memberDTO) {
//        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
//        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
//        MemberEntity memberEntity = getEntityManager().find(MemberEntity.class, memberDTO.getUserId());
//        if (memberEntity != null) {
//            memberEntity = getEntityManager().merge(memberDTO.toEntity());
//            resultInsideDTO.setId(memberEntity.getUserId());
//        } else {
//            resultInsideDTO.setKey(Constant.RESPONSE_KEY.RECORD_NOT_EXIST);
//        }
//        return resultInsideDTO;
//    }
//
    @Override
    public ResultInsideDTO deleteMemberById(Long userId) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        MemberEntity memberEntity = getEntityManager().find(MemberEntity.class, userId);
        getEntityManager().remove(memberEntity);
        return resultInsideDTO;
    }

    @Override
    public Datatable getDatatableMember(MemberDTO memberDTO) {
        BaseDTO baseDTO = sqlSearch(memberDTO);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(),
                baseDTO.getParameters(), memberDTO.getPage(), memberDTO.getPageSize(),
                MemberDTO.class,
                memberDTO.getSortName(), memberDTO.getSortType());
    }

    @Override
    public Datatable getDatatable(ManagerDTO managerDTO) {
        BaseDTO baseDTO = sqlSearch(managerDTO);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(),
                baseDTO.getParameters(), managerDTO.getPage(), managerDTO.getPageSize(),
                MemberDTO.class,
                managerDTO.getSortName(), managerDTO.getSortType());
    }

//    @Override
//    public List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO) {
//        BaseDTO baseDTO = sqlSearch(employeeDTO);
//        return getNamedParameterJdbcTemplate().query(baseDTO.getSqlQuery()
//                , baseDTO.getParameters()
//                , BeanPropertyRowMapper.newInstance(EmployeeDTO.class));
//    }
//
//    @Override
//    public List<Map<String, Object>> getListEmployeeMap() {
//
//        Map<String, Object> beanMap = new HashMap<>();
//        String sql = " select " +
//                " t.cot1 cot1, " +
//                " t.cot2 cot2, " +
//                " t.cot3 cot3 " +
//                " from " +
//                " tabledetest t " +
//                " where " +
//                " 1 = 1 ";
//        List<Map<String, Object>> mapResult = getNamedParameterJdbcTemplate().queryForList(sql, beanMap);
//        return mapResult;
//    }

    private BaseDTO sqlSearch(ManagerDTO managerDTO) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("member", "getDatatableMember");
        if (managerDTO != null) {
            if (!DataUtil.isNullOrEmpty(managerDTO.getSearchAll())) {
                sql += " And (lower(m.email) Like lower(:searchAll) OR lower(m.hoten) Like lower(:searchAll)) ";
                parameter.put("searchAll", DataUtil.convertSqlLike(managerDTO.getSearchAll()));
            }
        }
        sql += " ORDER BY m.hoten ASC ";
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }

    private BaseDTO sqlSearch(MemberDTO memberDTO) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("member", "getDatatableMember");
        if (memberDTO != null) {
            if (!DataUtil.isNullOrEmpty(memberDTO.getSearchAll())) {
                sql += " And (lower(m.email) Like lower(:searchAll) OR lower(m.hoten) Like lower(:searchAll)) ";
                parameter.put("searchAll", DataUtil.convertSqlLike(memberDTO.getSearchAll()));
            }
        }
        sql += " ORDER BY m.hoten ASC ";
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }
}
