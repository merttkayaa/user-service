package com.grpc.userservice.service.impl;

import com.grpc.userservice.client.PaymentClient;
import com.grpc.userservice.data.service.UserDataService;
import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.service.UserService;
import com.grpc.userservice.web.dto.CreateUser;
import grpc.userservice.PaymentServiceOuterClass;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDataService dbService;
    private final PaymentClient client;
    public UserServiceImpl(UserDataService dbService, PaymentClient client){
        this.dbService = dbService;
        this.client = client;
    }
    @Override
    public UserDto createUser(CreateUser createUser) {
        return dbService.create(createUser);
    }

    @Override
    public PaymentServiceOuterClass.PaymentDto pay(PaymentServiceOuterClass.CreatePayment createPayment) {
        PaymentServiceOuterClass.PaymentDto response = null;
        try {
           response = client.pay(createPayment);
        } catch (Exception e) {
           //TODO  handle et
        } finally {
            client.shutdown();
        }
        return response;
    }
}
