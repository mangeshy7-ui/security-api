package com.usd.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usd.security.entity.FirewallRules;

public interface FirewallRulesRepository extends JpaRepository<FirewallRules, Integer> {

}
