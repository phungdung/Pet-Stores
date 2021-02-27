package com.myproject.controller;

import com.myproject.business.PetBusiness;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/mapi/petController")
public class PetController {
    @Autowired
    PetBusiness petBusiness;

    @PostMapping(value = "/getDatatablePet")
    public ResponseEntity<Datatable> getDatatablePet(@RequestBody PetDTO petDTO) {
        Datatable datatable = petBusiness.getDatatablePet(petDTO);
        return new ResponseEntity<>(datatable, HttpStatus.OK);
    }

    @GetMapping(value = "/getDetail")
    public ResponseEntity<PetDTO> findPetById(@RequestParam Long petId) {
        PetDTO petDTO = petBusiness.findPetById(petId);
        return new ResponseEntity<>(petDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<ResultInsideDTO> insertPet(@RequestBody PetDTO petDTO) {
        ResultInsideDTO resultInsideDTO = petBusiness.insertPet(petDTO);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/updatePetInfo")
    public ResponseEntity<ResultInsideDTO> updatePetInfo(@RequestBody PetDTO petDTO) {
        ResultInsideDTO resultInsideDTO = petBusiness.updatePetInfo(petDTO);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<ResultInsideDTO> deletePetById(@RequestParam Long petId) {
        ResultInsideDTO resultInsideDTO = petBusiness.deletePetById(petId);
        return new ResponseEntity<>(resultInsideDTO, HttpStatus.OK);
    }
}
