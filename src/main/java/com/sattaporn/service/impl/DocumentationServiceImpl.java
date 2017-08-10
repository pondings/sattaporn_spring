package com.sattaporn.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

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

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/sattaporn";
	static final String USER = "postgres";
	static final String PASS = "password";

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
	public HashMap findDocument(Documentation documentation) {

		Connection connection = null;
		Statement statement = null;
		String sql = "SELECT sir_name as ทดสอบ,name FROM customer";
		HashMap obj = new HashMap<>();

		try {

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				int columnCount = rsMetaData.getColumnCount();
				for (int i = 1; i < columnCount+1; i++) {
					String column_name = rsMetaData.getColumnName(i);
					obj.put(column_name, rs.getObject(column_name));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
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
