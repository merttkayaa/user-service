package com.grpc.paymentservice.data.mapper;

import com.grpc.paymentservice.data.entity.User;
import com.grpc.paymentservice.dto.UserDto;
import com.grpc.paymentservice.web.dto.CreateUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
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
