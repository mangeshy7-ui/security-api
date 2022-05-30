package com.usd.security.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.usd.security.entity.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer>{

	@Modifying
	@Transactional
	@Query("update Configuration set activeSwitch=:activeSwitch where cnfId=:cnfId")
	void updateActiveSwitch(String activeSwitch,Integer cnfId);
    List<Configuration> findByActiveSwitch(String activeSwitch);
}
