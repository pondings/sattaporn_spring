package com.sattaporn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.model.Documentation;
import com.sattaporn.service.DocumentationService;

@RestController
@RequestMapping("ducmentation")
public class DocumentationRestcontroller {

	@Autowired
	DocumentationService documentService;
	
	@RequestMapping(path="uploadDocument",method=RequestMethod.POST)
	public ResponseEntity<?> createDocument(@RequestParam("file") Object obj) {
		MultipartFile file = (MultipartFile) obj;
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getOriginalFilename());
		return null;
	}
	
	@RequestMapping(path="find",method=RequestMethod.POST)
	public ResponseEntity<?> findDocumentation(@RequestBody Documentation documentation) {
		return null;
	}
	
	@RequestMapping(path="update",method=RequestMethod.PUT)
	public ResponseEntity<?> updateDocumentation(@RequestBody Documentation documentation) {
		return null;
	}
	
	@RequestMapping(path="remove/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> removeDocumentation(@PathVariable("id") int id) {
		return null;
	}
	
}
