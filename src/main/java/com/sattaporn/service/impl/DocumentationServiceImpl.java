package com.sattaporn.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.model.Customer;
import com.sattaporn.model.Documentation;
import com.sattaporn.repository.DocumentationRepository;
import com.sattaporn.service.DocumentationService;


@Service
@Transactional
public class DocumentationServiceImpl implements DocumentationService {

	@Autowired
	DocumentationRepository documentRepository;

	@Override
	public Documentation createDocument(MultipartFile file, String custId) {
		Documentation document = new Documentation();

		Customer customer = new Customer();
		customer.setId(Integer.parseInt(custId));

		try {
			document.setName(file.getOriginalFilename());
			document.setSource(file.getBytes());
			document.setType(file.getContentType());
			document.setCustomer(customer);
			document.setCreateBy("Sattaporn Klaiarmon");
			document.setCreateDate(new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Documentation createdDocument = documentRepository.save(document);
		createdDocument.setCode("DOCX" + String.format("%05d", createdDocument.getId()));
		Documentation updatedDocumentcode = documentRepository.save(createdDocument);
		return updatedDocumentcode;
	}

	@Override
	public List<Documentation> findDocument(Documentation documentation) {
		List<Documentation> documentList = documentRepository.findDocument(documentation);
		return documentList;
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

	@Override
	public List<Documentation> findAll() {
		List<Documentation> documentList = documentRepository.findAll();
		return documentList;
	}

}
