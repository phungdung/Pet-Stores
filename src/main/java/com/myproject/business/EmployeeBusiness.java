package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.EmployeeDTO;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface EmployeeBusiness {
    EmployeeDTO findEmployeeById(Long employeeId);

    ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO);

    ResultInsideDTO updateEmployee(EmployeeDTO employeeDTO);

    ResultInsideDTO deleteEmployeeById(Long employeeId);

    Datatable getListEmployeeDTO(EmployeeDTO employeeDTO);

    List<Map<String, Object>> getListEmployeeMap();

    List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO);

    File exportData(EmployeeDTO employeeDTO) throws Exception;

}
