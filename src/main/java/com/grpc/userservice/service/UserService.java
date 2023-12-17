package com.grpc.userservice.service;

import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.web.dto.CreateUser;

public interface UserService {

    UserDto createUser(CreateUser createUser);
}
