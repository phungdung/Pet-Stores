package com.myproject.data.entity;

import com.myproject.data.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PET")
public class PetEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvatnuoi")
    private Long petId;

    @Column(name = "idloaivatnuoi")
    private Long petTypeId;

    @Column(name = "idnguoiquantri")
    private Long managerId;

    @Column(name = "tenvatnuoi")
    private String petName;

    @Column(name = "hinhanh")
    private String picture;

    @Column(name = "tengiong")
    private String genusName;

    @Column(name = "tuoi")
    private String age;

    @Column(name = "gioitinh")
    private String gender;

    @Column(name = "cannang")
    private String weight;

    @Column(name = "mausac")
    private String color;

    @Column(name = "datiemphong")
    private Long vaccination;

    @Column(name = "datrietsan")
    private Long sterilization;

    @Column(name = "ngaythemvao")
    private Date createTime;

    @Column(name = "ngaycapnhat")
    private Date updateTime;

    @Column(name = "thongtinthem")
    private String moreInformation;

    @Column(name = "trangthai")
    private String status;


    public PetDTO toDto() {
        return new PetDTO(
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
