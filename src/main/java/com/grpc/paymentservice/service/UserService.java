package com.grpc.paymentservice.service;

import com.grpc.paymentservice.dto.UserDto;
import com.grpc.paymentservice.web.dto.CreateUser;
import com.grpc.paymentservice.web.dto.PaymentRequest;
import grpc.paymentservice.PaymentServiceOuterClass;

public interface UserService {

    UserDto createUser(CreateUser createUser);

    PaymentServiceOuterClass.PaymentDto pay(PaymentRequest request) throws InterruptedException;
}
