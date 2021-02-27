package com.myproject.repository;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetDTO;

import java.util.List;

public interface PetRepository {

    PetDTO findPetById(Long petId);

    ResultInsideDTO insertPet(PetDTO petDTO);

    ResultInsideDTO updatePetInfo(PetDTO petDTO);

    ResultInsideDTO deletePetById(Long petId);

    Datatable getDatatablePet(PetDTO petDTO);

    List<PetDTO> getListDataExport(PetDTO petDTO);
}
