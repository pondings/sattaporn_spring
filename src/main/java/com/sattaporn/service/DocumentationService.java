package com.sattaporn.service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.model.Documentation;

public interface DocumentationService {

	public Documentation createDocument(MultipartFile file, String custCode);
	
	public HashMap findDocument(Documentation documentation);
	
	public Documentation updateDocument(Documentation documentation);
	
	public void removeDocument(int id) ;
	
}
