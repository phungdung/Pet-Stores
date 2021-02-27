package com.myproject.repository;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;

public interface MemberRepository {

    MemberDTO findMemberById(Long userId);

//    ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO);
//
//    ResultInsideDTO updateMemberInfo(MemberDTO memberDTO);
//
    ResultInsideDTO deleteMemberById(Long userId);

    Datatable getDatatableMember(MemberDTO memberDTO);

//    List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO);
//
//    List<Map<String, Object>> getListEmployeeMap();

    Datatable getDatatable(ManagerDTO managerDTO);
}
