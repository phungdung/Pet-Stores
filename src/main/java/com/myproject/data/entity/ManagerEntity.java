package com.myproject.data.entity;

import com.myproject.data.dto.ManagerDTO;
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
@Table(name = "MANAGER")
public class ManagerEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnguoiquantri")
    private Long managerId;

    @Column(name = "password")
    private String password;

    @Column(name = "hoten")
    private String fullName;

    @Column(name = "sodienthoai")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "cccd")
    private String identityCard;

    @Column(name = "ngaysinh")
    private Date dateOfBirth;

    @Column(name = "diachi")
    private String address;

    @Column(name = "chucvu")
    private String roleCode;

    @Column(name = "trangthai")
    private String status;

    public ManagerDTO toDto() {
        return new ManagerDTO(
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
