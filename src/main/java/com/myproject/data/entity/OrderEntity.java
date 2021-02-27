package com.myproject.data.entity;

import com.myproject.data.dto.OrderDTO;
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
@Table(name = "ORDERS")
public class OrderEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddonnhannuoi")
    private Long orderId;

    @Column(name = "idkhachhang")
    private Long userId;

    @Column(name = "idnguoiquantri")
    private Long managerId;

    @Column(name = "idvatnuoi")
    private Long petId;

    @Column(name = "lydo")
    private String reason;

    @Column(name = "khaibaodieukien")
    private String condition;

    @Column(name = "ngayguidon")
    private Date sentDate;

    @Column(name = "ngayduyetnuoi")
    private Date approvalDate;

    @Column(name = "ngaygiaovatnuoi")
    private Date deliveryDate;

    @Column(name = "trangthai")
    private String status;

    public OrderDTO toDto() {
        return new OrderDTO(
                orderId,
                userId,
                managerId,
                petId,
                reason,
                condition,
                sentDate,
                approvalDate,
                deliveryDate,
                status
        );
    }
}
