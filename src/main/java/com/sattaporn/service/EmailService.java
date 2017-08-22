package com.sattaporn.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

	public void sendMail(MultipartFile[] files) ;
	
}
