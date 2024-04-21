package com.grpc.paymentservice.service.impl;

import com.grpc.paymentservice.client.PaymentClient;
import com.grpc.paymentservice.data.service.UserDataService;
import com.grpc.paymentservice.dto.UserDto;
import com.grpc.paymentservice.service.UserService;
import com.grpc.paymentservice.web.dto.CreateUser;
import com.grpc.paymentservice.web.dto.PaymentRequest;
import grpc.paymentservice.PaymentServiceOuterClass;
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
    public PaymentServiceOuterClass.PaymentDto pay(PaymentRequest request) {
        PaymentServiceOuterClass.PaymentDto response = null;

        PaymentServiceOuterClass.CreatePayment createPayment = PaymentServiceOuterClass.CreatePayment.newBuilder()
                .setPaymentMethod(request.getPaymentMethod())
                .setAmount(request.getAmount())
                .setBankId(request.getBankId())
                .setCardNumber(request.getCardNumber())
                .setCvv(request.getCvv())
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setExpireDate(request.getExpireDate())
                .build();
        try {
           response = client.pay(createPayment);
        } catch (Exception e) {
            String errorMessagfe = e.getMessage();
            String deneme = errorMessagfe;
           //TODO  handle et
        } finally {
//            client.shutdown();
        }
        return response;
    }
}
