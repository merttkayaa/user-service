package com.grpc.userservice.service;

import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.web.dto.CreateUser;
import grpc.userservice.PaymentServiceOuterClass;

public interface UserService {

    UserDto createUser(CreateUser createUser);

    PaymentServiceOuterClass.PaymentDto pay(PaymentServiceOuterClass.CreatePayment createPayment) throws InterruptedException;
}
