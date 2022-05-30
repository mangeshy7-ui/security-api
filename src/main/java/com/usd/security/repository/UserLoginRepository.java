package com.usd.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usd.security.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

}
