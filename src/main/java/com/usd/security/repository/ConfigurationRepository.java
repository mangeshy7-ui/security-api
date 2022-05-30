package com.usd.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usd.security.entity.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer>{

}
