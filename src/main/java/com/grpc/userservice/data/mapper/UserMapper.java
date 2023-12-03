package com.grpc.userservice.data.mapper;

import com.grpc.userservice.data.entity.User;
import com.grpc.userservice.dto.UserDto;
import com.grpc.userservice.web.controller.dto.CreateUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public User toEntity(CreateUser createUser) {
        User user = new User();
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setCardNumber(createUser.getPaymentInfo().getCardNumber());
        user.setExpireMonth(createUser.getPaymentInfo().getExpireMonth());
        user.setExpireYear(createUser.getPaymentInfo().getExpireYear());
        user.setCvv(createUser.getPaymentInfo().getCvv());

        return user;
    }

    public abstract UserDto toDto(User user);
}
