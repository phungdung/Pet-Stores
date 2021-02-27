package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.MemberEntity;
import com.myproject.data.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredTypes()
public class OrderDTO extends BaseDTO {

    private Long orderId;
    private Long userId;
    private Long managerId;
    private Long petId;
    private String reason;
    private String condition;
    private Date sentDate;
    private Date approvalDate;
    private Date deliveryDate;
    private String status;

    private String statusStr;

    public OrderDTO(Long orderId,
                    Long userId,
                    Long managerId,
                    Long petId,
                    String reason,
                    String condition,
                    Date sentDate,
                    Date approvalDate,
                    Date deliveryDate,
                    String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.managerId = managerId;
        this.petId = petId;
        this.reason = reason;
        this.condition = condition;
        this.sentDate = sentDate;
        this.approvalDate = approvalDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public OrderEntity toEntity() {
        return new OrderEntity(
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
