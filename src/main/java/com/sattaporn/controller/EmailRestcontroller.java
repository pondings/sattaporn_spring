package com.sattaporn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.model.Email;
import com.sattaporn.service.EmailService;

@RestController
@RequestMapping("email")
public class EmailRestcontroller {

	@Autowired
	EmailService emailservice ;
	
	@RequestMapping(path="send", method=RequestMethod.POST)
	public void sendEmail(@RequestParam("files") MultipartFile[] files, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("content") String content, @RequestParam("sendFrom") String sendFrom,
			@RequestParam("sendTo") String sendTo, @RequestParam("subject") String subject) {
		Email email = new Email() ;
		
		email.setUsername(username);
		email.setPassword(password);
		email.setContent(content);
		email.setSendFrom(sendFrom);
		email.setSendTo(sendTo);
		email.setSubject(subject);
		
		System.out.println("Email =  " + email.toString());
		
//		emailservice.sendMail(files);
		
	}
	
	
}
