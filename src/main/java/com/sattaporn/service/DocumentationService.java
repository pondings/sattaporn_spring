package com.sattaporn.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.dto.DocumentationDTO;
import com.sattaporn.model.Documentation;

public interface DocumentationService {

	public Documentation createDocument(MultipartFile file, String custCode);
	
	public List<Documentation> findDocument(DocumentationDTO documentation);
	
	public Documentation updateDocument(Documentation documentation);
	
	public void removeDocument(int id) ;
	
	public List<Documentation> findAll();
	
}
