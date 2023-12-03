package com.grpc.userservice.dto;

import com.grpc.userservice.web.controller.dto.PaymentInfo;
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
