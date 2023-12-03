package com.grpc.userservice.web.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInfo {
    private String cardNumber;
    private String cvv;
    private String expireMonth;
    private String expireYear;
}
