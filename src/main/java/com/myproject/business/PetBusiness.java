package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetDTO;

import java.io.File;

public interface PetBusiness {
    PetDTO findPetById(Long petId);

    ResultInsideDTO insertPet(PetDTO petDTO);

    ResultInsideDTO updatePetInfo(PetDTO petDTO);

    ResultInsideDTO deletePetById(Long petId);

    Datatable getDatatablePet(PetDTO petDTO);

    File exportData(PetDTO petDTO) throws Exception;

}
