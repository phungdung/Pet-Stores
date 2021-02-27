package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.data.dto.MemberDTO;

public interface MemberBusiness {
    MemberDTO findMemberById(Long userId);

//    ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO);
//
//    ResultInsideDTO updateMemberInfo(MemberDTO memberDTO);
//
//    ResultInsideDTO deleteEmployeeById(Long employeeId);

    Datatable getDatatableMember(MemberDTO memberDTO);

//    List<Map<String, Object>> getListEmployeeMap();
//
//    List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO);
//
//    File exportData(EmployeeDTO employeeDTO) throws Exception;

}
