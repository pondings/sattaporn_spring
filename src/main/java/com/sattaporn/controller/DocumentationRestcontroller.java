package com.sattaporn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.dto.DocumentationDTO;
import com.sattaporn.model.Documentation;
import com.sattaporn.service.DocumentationService;

@CrossOrigin 
@RestController
@RequestMapping("documentation")
public class DocumentationRestcontroller {

	@Autowired
	DocumentationService documentService;
	
	@RequestMapping(path="uploadDocument",method=RequestMethod.POST)
	public ResponseEntity<?> createDocument(@RequestParam("file") MultipartFile file, @RequestParam("custId") String custId) {
		Documentation insertedDociment = documentService.createDocument(file, custId);
		return new ResponseEntity<Documentation>(insertedDociment, HttpStatus.OK);
	}
	
	@RequestMapping(path="find",method=RequestMethod.POST)
	public ResponseEntity<?> findDocumentation(@RequestBody DocumentationDTO documentation) {
		List<Documentation> documentList = documentService.findDocument(documentation);
		return new ResponseEntity<List<Documentation>>(documentList, HttpStatus.OK);
	}
	
	@RequestMapping(path="update",method=RequestMethod.PUT)
	public ResponseEntity<?> updateDocumentation(@RequestBody Documentation documentation) {
		return null;
	}
	
	@RequestMapping(path="remove/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> removeDocumentation(@PathVariable("id") int id) {
		
		try {
			documentService.removeDocument(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Delete complete !", HttpStatus.OK);
	}
	
	@RequestMapping(path="findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Documentation> documentList = documentService.findAll();
		return new ResponseEntity<List<Documentation>>(documentList,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/downloadDocument/{code}" , method = RequestMethod.GET)
	public ResponseEntity<?> downloadDocument(@PathVariable String code) {
		DocumentationDTO documentationDTO = new DocumentationDTO();
		documentationDTO.setSearchKeyword(code);;
		documentationDTO.setFindMethod("code");
		
		List<Documentation> documentList = documentService.findDocument(documentationDTO);
		Documentation targetDocument = documentList.get(0);

		return new ResponseEntity<byte[]>(targetDocument.getSource(),HttpStatus.OK);	

	}

	
}
