package com.myproject.data.entity;

import com.myproject.data.dto.MemberDTO;
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
@Table(name = "MEMBER")
public class MemberEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkhachhang")
    private Long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "hoten")
    private String fullName;

    @Column(name = "sodienthoai")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "ngaysinh")
    private Date dateOfBirth;

    @Column(name = "diachi")
    private String address;

    @Column(name = "trangthai")
    private String status;

    public MemberDTO toDto() {
        return new MemberDTO(
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
