package com.usd.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usd.security.entity.UserManagement;

public interface UserManagementRepository extends JpaRepository<UserManagement, Integer> {

	/*
	 * Boolean existsByPhoneNumber(String phoneNumber);
	 * 
	 * Boolean existsByKyc(String companyDomain); Boolean existsByEmail(String
	 * email);
	 * 
	 * 
	 * @Query(value = "SELECT * FROM company_register WHERE id = ?1", nativeQuery =
	 * true) CompanyRegister getCompanyById(Integer id);
	 * 
	 * boolean existsByUserId(Integer userId);
	 */

}
