package com.usd.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usd.security.entity.IpServer;

public interface IpServerRepository extends JpaRepository<IpServer ,Integer> {

}
