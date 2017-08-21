package com.sattaporn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("email")
public class EmailRestcontroller {

	
	@RequestMapping(path="send", method=RequestMethod.POST)
	public void sendEmail(@RequestParam("files") MultipartFile[] files) {
		System.out.println("File list size " + files.length);
		
		
//		for(MultipartFile file: emailDTO.getMultipartFileList()) {
//			System.out.println("file name : " + file.getOriginalFilename());
//		} 
	}
	
	
}
