package com.myproject.repository;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;

public interface ManagerRepository {

    ManagerDTO findManagerById(Long managerId);

//    ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO);
//
//    ResultInsideDTO updateMemberInfo(MemberDTO memberDTO);

    ResultInsideDTO deleteManagerById(Long managerId);

    Datatable getDatatableManager(ManagerDTO managerDTO);

//    List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO);
//
//    List<Map<String, Object>> getListEmployeeMap();
}
