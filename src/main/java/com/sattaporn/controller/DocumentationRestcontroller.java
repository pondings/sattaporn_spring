package com.sattaporn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.model.Documentation;

@RestController
@RequestMapping("ducmentation")
public class DocumentationRestcontroller {

	@RequestMapping(path="create",method=RequestMethod.POST)
	public ResponseEntity<?> createDocument(@RequestBody Documentation documentation) {
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
