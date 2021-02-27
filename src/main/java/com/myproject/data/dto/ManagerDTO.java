package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.ManagerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredTypes()
public class ManagerDTO extends BaseDTO {

    private Long managerId;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String identityCard;
    private Date dateOfBirth;
    private String address;
    private String roleCode;
    private String status;

    private String statusStr;
    private String checkInputSearch;
    private Set<String> roles = new HashSet<>();

    public ManagerDTO(Long managerId,
                      String password,
                      String fullName,
                      String phoneNumber,
                      String email,
                      String identityCard,
                      Date dateOfBirth,
                      String address,
                      String roleCode,
                      String status) {
        this.managerId = managerId;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identityCard = identityCard;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.roleCode = roleCode;
        this.status = status;
    }

    public ManagerEntity toEntity() {
        return new ManagerEntity(
                managerId,
                password,
                fullName,
                phoneNumber,
                email,
                identityCard,
                dateOfBirth,
                address,
                roleCode,
                status
        );
    }
}
