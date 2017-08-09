package com.sattaporn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.Documentation;
import com.sattaporn.repository.DocumentationRepository;
import com.sattaporn.service.DocumentationService;

@Service
@Transactional
public class DocumentationServiceImpl implements DocumentationService{

	@Autowired
	DocumentationRepository documentRepository;
	
	@Override
	public Documentation createDocument(Documentation documentation) {
		Documentation createdDocument = documentRepository.save(documentation);
		createdDocument.setCode("DOCX"+String.format("%05d", createdDocument.getId()));
		Documentation updatedDocumentcode = documentRepository.save(createdDocument);
		return updatedDocumentcode;
	}

	@Override
	public Documentation findDocument(Documentation documentation) {
		
		return null;
	}

	@Override
	public Documentation updateDocument(Documentation documentation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeDocument(int id) {
		// TODO Auto-generated method stub
		
	}

}
