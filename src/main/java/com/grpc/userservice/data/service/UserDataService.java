package com.grpc.userservice.data.service;

import com.grpc.userservice.data.repository.UserRepository;
import com.grpc.userservice.data.entity.User;
import com.grpc.userservice.data.mapper.UserMapper;
import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.web.dto.CreateUser;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
    private final UserMapper mapper;
    private final UserRepository repository;

    public UserDataService(UserMapper mapper, UserRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public UserDto create(CreateUser createUser){
        User createdEntity = repository.save(mapper.toEntity(createUser));
        return mapper.toDto(createdEntity);
    }
}
