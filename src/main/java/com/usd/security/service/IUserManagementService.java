package com.usd.security.service;

import java.util.List;

import com.usd.security.entity.UserManagement;

public interface IUserManagementService {
    
	public Integer saveUserManagement(UserManagement umanagement);
	public List<UserManagement> getAllUserManagement();
	public UserManagement getOneUserManagement(Integer id);
	public void deleteUserManagement(Integer id);
 
  
}
