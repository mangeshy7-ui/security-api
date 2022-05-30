package com.usd.security.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usd.security.service.impl.EmailService;

@Controller
public class ForgotController {
	@Autowired
	private EmailService emailService;
	Random random=new Random(1000);
    @RequestMapping("/forgot")
	public String openEmaiForm() {
		return "forgotEmailForm";
	}
	
    @PostMapping("/sendOtp")
    
    public String sendOtp(@RequestParam("email") String email, HttpSession session) {
    	 
    	//generating otp of four digit
    	
    	int otp=random.nextInt(999999);
    	
    	//write code for send otp to email
    	String subject="otp from security api";
    	String message="<h1> otp="+otp+" <h1>";
    	String to=email;
    	
    	boolean flag=this.emailService.sendEmail(subject, message, to);
    	if(flag) {
    		return "verify_otp";
    		
    	}else {
    		session.setAttribute("message", "check your email id !!");
    	}
    	
      return "forgotEmailForm";
    }
}
