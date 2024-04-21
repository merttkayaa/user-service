package com.grpc.paymentservice.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUser {
    private String firstName;
    private String lastName;
    private PaymentInfo paymentInfo;
}
