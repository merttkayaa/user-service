package com.grpc.paymentservice.dto;

import com.grpc.paymentservice.web.dto.PaymentInfo;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private PaymentInfo paymentInfo;
}
