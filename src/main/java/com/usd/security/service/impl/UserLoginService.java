package com.usd.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.security.entity.UserLogin;
import com.usd.security.repository.UserLoginRepository;
import com.usd.security.service.IUserLoginService;
@Service
public class UserLoginService implements IUserLoginService {
	
	@Autowired
	private UserLoginRepository loginRepository ;

	@Override
	public Integer saveUserLogin(UserLogin userLogin) {
		
		Integer id=loginRepository.save(userLogin).getId();
		return id;
	}

}
