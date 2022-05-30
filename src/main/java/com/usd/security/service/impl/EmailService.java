package com.usd.security.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to) {
		
		boolean f=false;
		String from="yeoleusd@gmail.com";
		
		//variable for gmail
		String host="smtp.gmail.com";
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable",true);
		properties.put("mail.smtp.auth","true");
		
		//to get the session object..
		Session session=Session.getDefaultInstance(properties, new Authenticator() {
			 @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("yeolemng@gmail.com","your password");
			 }
		});
		 session.setDebug(true);
		 //compose the message
		 MimeMessage mimeMessage=new MimeMessage(session);
		 try {
			// from email
			 mimeMessage.setFrom(from);
			 
			 //adding recipient to message
			 mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			 
			 //adding subject to message
			 mimeMessage.setSubject(subject);
			 
			 //adding text to message
			 mimeMessage.setText(message);
			 
			 //step 3. send message using transport class
			 Transport.send(mimeMessage);
			 
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 return true;
	}

}
