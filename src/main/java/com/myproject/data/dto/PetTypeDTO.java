package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.PetTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredTypes()
public class PetTypeDTO extends BaseDTO {

    private Long petTypeId;
    private String petTypeName;

    public PetTypeEntity toEntity() {
        return new PetTypeEntity(
                petTypeId,
                petTypeName
        );
    }
}
