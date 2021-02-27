package com.myproject.controller;

import com.myproject.business.ManagerBusiness;
import com.myproject.business.MemberBusiness;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/mapi/managerController")
public class ManagerController {
    @Autowired
    ManagerBusiness managerBusiness;

    //1: truyền page, pagesize, searchAll
    //2: tạo 1 nút chọn tìm nhân viên, nếu chọn thì truyền vào checkInputSearch = 1
    @PostMapping(value = "/getDatatable")
    public ResponseEntity<Datatable> getDatatable(@RequestBody ManagerDTO managerDTO) {
        Datatable datatable = managerBusiness.getDatatable(managerDTO);
        return new ResponseEntity<>(datatable, HttpStatus.OK);
    }

        @GetMapping(value = "/getDetail")
    public ResponseEntity<ManagerDTO> findManagerById(@RequestParam Long managerId) {
        ManagerDTO managerDTO = managerBusiness.findManagerById(managerId);
        return new ResponseEntity<>(managerDTO, HttpStatus.OK);
    }
//
//    @PostMapping(value = "/insert")
//    public ResponseEntity<ResultInsideDTO> insertEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        ResultInsideDTO resultInsideDTO = employeeBusiness.insertEmployee(employeeDTO);
//        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/updateMemberInfo")
//    public ResponseEntity<ResultInsideDTO> updateMemberInfo(@RequestBody MemberDTO memberDTO) {
//        ResultInsideDTO resultInsideDTO = memberBusiness.updateMemberInfo(memberDTO);
//        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
//    }
//
    //1: truyền id bên ngoài vào
    //2: truyền checkInputSearch = 1 nếu chọn như trên màn search
    @GetMapping(value = "/delete")
    public ResponseEntity<ResultInsideDTO> deleteById(@RequestParam String checkInputSearch, @RequestParam Long managerId) {
        ResultInsideDTO resultInsideDTO = managerBusiness.deleteById(checkInputSearch, managerId);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }
//
//    //Test queryForList
//    @GetMapping(value = "/findAll")
//    public ResponseEntity<List<Map<String, Object>>> getListEmployeeDTO() {
//        List<Map<String, Object>> objectMap = employeeBusiness.getListEmployeeMap();
//        return new ResponseEntity<>(objectMap, HttpStatus.OK);
//    }
//
//    //Test getListDataExport
//    @PostMapping(value = "/getListDataExport")
//    public ResponseEntity<List<EmployeeDTO>> getListDataExport(@RequestBody EmployeeDTO employeeDTO) {
//        List<EmployeeDTO> employeeDTOList = employeeBusiness.getListDataExport(employeeDTO);
//        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
//    }

}
