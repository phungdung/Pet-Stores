package com.myproject.controller;

import com.myproject.business.MemberBusiness;
import com.myproject.common.dto.Datatable;
import com.myproject.data.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/mapi/memberController")
public class MemberController {
    @Autowired
    MemberBusiness memberBusiness;

    @PostMapping(value = "/getDatatableMember")
    public ResponseEntity<Datatable> getDatatableMember(@RequestBody MemberDTO memberDTO) {
        Datatable datatable = memberBusiness.getDatatableMember(memberDTO);
        return new ResponseEntity<>(datatable, HttpStatus.OK);
    }

    @GetMapping(value = "/getDetail")
    public ResponseEntity<MemberDTO> findMemberById(@RequestParam Long userId) {
        MemberDTO memberDTO = memberBusiness.findMemberById(userId);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
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
//    @GetMapping(value = "/delete")
//    public ResponseEntity<ResultInsideDTO> deleteEmployeeById(@RequestParam Long employeeId) {
//        ResultInsideDTO resultInsideDTO = employeeBusiness.deleteEmployeeById(employeeId);
//        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
//    }
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
