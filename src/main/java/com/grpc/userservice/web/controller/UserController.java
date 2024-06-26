package com.grpc.userservice.web.controller;


import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.service.UserService;
import com.grpc.userservice.web.dto.CreateUser;
import grpc.userservice.PaymentServiceOuterClass;
import lombok.SneakyThrows;
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
    public ResponseEntity<PaymentServiceOuterClass.PaymentDto>  pay(@RequestBody PaymentServiceOuterClass.CreatePayment createPayment) throws InterruptedException {
        //TODO Exception signaturedan kurtul!!!
        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.pay(createPayment));
    }

}
