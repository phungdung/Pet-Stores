package com.myproject.controller;

import com.myproject.business.PetTypeBusiness;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/mapi/petTypeController")
public class PetTypeController {
    @Autowired
    PetTypeBusiness petTypeBusiness;

    @PostMapping(value = "/getDatatablePetType")
    public ResponseEntity<Datatable> getDatatablePetType(@RequestBody PetTypeDTO petTypeDTO) {
        Datatable datatable = petTypeBusiness.getDatatablePetType(petTypeDTO);
        return new ResponseEntity<>(datatable, HttpStatus.OK);
    }

    @GetMapping(value = "/getDetail")
    public ResponseEntity<PetTypeDTO> findPetTypeById(@RequestParam Long petTypeId) {
        PetTypeDTO petTypeDTO = petTypeBusiness.findPetTypeById(petTypeId);
        return new ResponseEntity<>(petTypeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<ResultInsideDTO> insertPetType(@RequestBody PetTypeDTO petTypeDTO) {
        ResultInsideDTO resultInsideDTO = petTypeBusiness.insertPetType(petTypeDTO);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/updatePetTypeInfo")
    public ResponseEntity<ResultInsideDTO> updatePetTypeInfo(@RequestBody PetTypeDTO petTypeDTO) {
        ResultInsideDTO resultInsideDTO = petTypeBusiness.updatePetTypeInfo(petTypeDTO);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<ResultInsideDTO> deletePetTypeById(@RequestParam Long petTypeId) {
        ResultInsideDTO resultInsideDTO = petTypeBusiness.deletePetTypeById(petTypeId);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }
}
