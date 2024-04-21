package com.grpc.paymentservice.data.repository;

import com.grpc.paymentservice.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
