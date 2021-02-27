package com.myproject.business;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.PetTypeDTO;
import com.myproject.repository.PetTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PetTypeBusinessImpl implements PetTypeBusiness {
    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public PetTypeDTO findPetTypeById(Long petTypeId) {
        log.info("findPetTypeById", petTypeId);
        return petTypeRepository.findPetTypeById(petTypeId);
    }

    @Override
    public ResultInsideDTO insertPetType(PetTypeDTO petDTO) {
        log.info("insertPetType", petDTO);
        return petTypeRepository.insertPetType(petDTO);
    }

    @Override
    public ResultInsideDTO updatePetTypeInfo(PetTypeDTO petDTO) {
        log.info("updatePetTypeInfo", petDTO);
        return petTypeRepository.updatePetTypeInfo(petDTO);
    }

    @Override
    public ResultInsideDTO deletePetTypeById(Long petTypeId) {
        log.info("deletePetTypeById", petTypeId);
        return petTypeRepository.deletePetTypeById(petTypeId);
    }

    @Override
    public Datatable getDatatablePetType(PetTypeDTO petDTO) {
        log.info("getDatatablePetType", petDTO);
        return petTypeRepository.getDatatablePetType(petDTO);
    }
}
