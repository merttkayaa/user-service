package com.grpc.paymentservice.data.service;

import com.grpc.paymentservice.data.repository.UserRepository;
import com.grpc.paymentservice.data.entity.User;
import com.grpc.paymentservice.data.mapper.UserMapper;
import com.grpc.paymentservice.dto.UserDto;
import com.grpc.paymentservice.web.dto.CreateUser;
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
