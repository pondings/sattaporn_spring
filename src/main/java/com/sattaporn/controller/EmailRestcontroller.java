package com.sattaporn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.service.EmailService;

@RestController
@RequestMapping("email")
public class EmailRestcontroller {

	@Autowired
	EmailService emailservice ;
	
	@RequestMapping(path="send", method=RequestMethod.POST)
	public void sendEmail(@RequestParam("files") MultipartFile[] files) {
		System.out.println("File list size " + files.length);
		emailservice.sendMail(files);
		
	}
	
	
}
