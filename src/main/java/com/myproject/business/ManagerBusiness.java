package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;

public interface ManagerBusiness {
    ManagerDTO findManagerById(Long managerId);

//    ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO);
//
//    ResultInsideDTO updateMemberInfo(MemberDTO memberDTO);
//
    ResultInsideDTO deleteById(String checkInputSearch, Long managerId);

    Datatable getDatatable(ManagerDTO managerDTO);

//    List<Map<String, Object>> getListEmployeeMap();
//
//    List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO);
//
//    File exportData(EmployeeDTO employeeDTO) throws Exception;

}
