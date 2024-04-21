package com.grpc.paymentservice.web.controller;


import com.grpc.paymentservice.dto.UserDto;
import com.grpc.paymentservice.service.UserService;
import com.grpc.paymentservice.web.dto.CreateUser;
import com.grpc.paymentservice.web.dto.PaymentRequest;
import grpc.paymentservice.PaymentServiceOuterClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUser createUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUser));
    }


    @PostMapping("/pay")
    public ResponseEntity<PaymentServiceOuterClass.PaymentDto>  pay(@RequestBody PaymentRequest request) throws InterruptedException {
        //TODO Exception signaturedan kurtul!!!

        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.pay(request));
    }

}
