package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.MemberEntity;
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
public class MemberDTO extends BaseDTO {

    private Long userId;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private String address;
    private String status;

    private String statusStr;
    private Set<String> roles = new HashSet<>();

    public MemberDTO(Long userId,
                     String password,
                     String fullName,
                     String phoneNumber,
                     String email,
                     Date dateOfBirth,
                     String address,
                     String status) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
    }

    public MemberDTO(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public MemberEntity toEntity() {
        return new MemberEntity(
                userId,
                password,
                fullName,
                phoneNumber,
                email,
                dateOfBirth,
                address,
                status
        );
    }
}
