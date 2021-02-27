package com.myproject.data.entity;

import com.myproject.data.dto.PetTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PET_TYPE")
public class PetTypeEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloaivatnuoi")
    private Long petTypeId;

    @Column(name = "tenloaivatnuoi")
    private String petTypeName;

    public PetTypeDTO toDto() {
        return new PetTypeDTO(
                petTypeId,
                petTypeName
        );
    }
}
