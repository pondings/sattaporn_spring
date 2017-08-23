package com.sattaporn.service;

import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.model.Email;

public interface EmailService {

	public void sendMail(MultipartFile[] files, Email email) ;
	
}
