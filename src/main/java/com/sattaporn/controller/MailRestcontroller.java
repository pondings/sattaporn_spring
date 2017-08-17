package com.sattaporn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.service.MailService;

@RestController
@RequestMapping("mail")
public class MailRestcontroller {

	@Autowired
	MailService mailService;
	
	@RequestMapping(path="sendMail", method= RequestMethod.GET)
	public void sendMail() {
		mailService.sendMail();
	}
	
}
