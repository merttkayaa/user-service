package com.grpc.userservice.service.impl;

import com.grpc.userservice.data.service.UserDataService;
import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.service.UserService;
import com.grpc.userservice.web.dto.CreateUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDataService dbService;
    public UserServiceImpl(UserDataService dbService){
        this.dbService = dbService;
    }
    @Override
    public UserDto createUser(CreateUser createUser) {
        return dbService.create(createUser);
    }
}
