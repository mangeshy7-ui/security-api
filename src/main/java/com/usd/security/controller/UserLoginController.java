package com.usd.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usd.security.entity.UserLogin;
import com.usd.security.service.IUserLoginService;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {
    
	@Autowired
	private IUserLoginService iUserLoginService ;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUserLogin(@RequestBody UserLogin userLogin){
		
		Integer id=iUserLoginService.saveUserLogin(userLogin);
		return ResponseEntity.ok("user  "+id+" is saved");
	}
}
