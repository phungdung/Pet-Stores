package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.PetEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredTypes()
public class PetDTO extends BaseDTO {

    private Long petId;
    private Long petTypeId;
    private Long managerId;
    private String petName;
    private String picture;
    private String genusName;
    private String age;
    private String gender;
    private String weight;
    private String color;
    private Long vaccination;
    private Long sterilization;
    private Date createTime;
    private Date updateTime;
    private String moreInformation;
    private String status;

    private String statusStr;

    public PetDTO(Long petId,
                  Long petTypeId,
                  Long managerId,
                  String petName,
                  String picture,
                  String genusName,
                  String age,
                  String gender,
                  String weight,
                  String color,
                  Long vaccination,
                  Long sterilization,
                  Date createTime,
                  Date updateTime,
                  String moreInformation,
                  String status) {
        this.petId = petId;
        this.petTypeId = petTypeId;
        this.managerId = managerId;
        this.petName = petName;
        this.picture = picture;
        this.genusName = genusName;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.color = color;
        this.vaccination = vaccination;
        this.sterilization = sterilization;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.moreInformation = moreInformation;
        this.status = status;
    }

    public PetEntity toEntity() {
        return new PetEntity(
                petId,
                petTypeId,
                managerId,
                petName,
                picture,
                genusName,
                age,
                gender,
                weight,
                color,
                vaccination,
                sterilization,
                createTime,
                updateTime,
                moreInformation,
                status
        );
    }
}
