package com.usd.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.security.entity.UserManagement;
import com.usd.security.exception.UserManagementNotFoundException;
import com.usd.security.repository.UserManagementRepository;
import com.usd.security.service.IUserManagementService;
@Service
public class UserManagementService implements IUserManagementService {
	
	@Autowired
	private UserManagementRepository managementRepository;

	@Override
	public Integer saveUserManagement(UserManagement umanagement) {
		Integer id=managementRepository.save(umanagement).getUserId();
		return id;
	}

	public List<UserManagement> getAllUserManagement() {
		List<UserManagement> list=managementRepository.findAll();
		return list;
	}

	public UserManagement getOneUserManagement(Integer id) {
		 Optional<UserManagement> opt=managementRepository.findById(id);
	       /* Configuration cnf=opt.orElseThrow(()-> new ConfigurationNotFoundException("configuration not exitst") );*/
	        
		 UserManagement usermanage=null;
	        if(opt.isPresent()) {
	        	usermanage=opt.get();
	        	
	        }else {
	        	throw new UserManagementNotFoundException("managementRepository");
	        }
			
			return usermanage;
	}

	public void deleteUserManagement(Integer id) {
		UserManagement umn=getOneUserManagement(id);
		managementRepository.delete(umn);
		
	}


}
