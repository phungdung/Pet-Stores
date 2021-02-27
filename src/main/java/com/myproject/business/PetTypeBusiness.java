package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetTypeDTO;

public interface PetTypeBusiness {
    PetTypeDTO findPetTypeById(Long petTypeId);

    ResultInsideDTO insertPetType(PetTypeDTO petTypeDTO);

    ResultInsideDTO updatePetTypeInfo(PetTypeDTO petTypeDTO);

    ResultInsideDTO deletePetTypeById(Long petTypeId);

    Datatable getDatatablePetType(PetTypeDTO petTypeDTO);
}
