package com.sattaporn.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.dto.DocumentationDTO;
import com.sattaporn.model.Documentation;
import com.sattaporn.model.Email;
import com.sattaporn.service.DocumentationService;
import com.sattaporn.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	DocumentationService documentService;
	
	@Override
	public void sendMail(MultipartFile[] files, Email email, String[] docCodes) throws Exception {
		Properties props = getEmailProperties();
		Session session = getAuthenicationSession(email.getUsername(), email.getPassword(), props);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getSendFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getSendTo()));
			message.setSubject(email.getSubject());
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPath = new MimeBodyPart();
			messageBodyPath.setText(email.getContent());
			multipart.addBodyPart(messageBodyPath);
			
			for (MultipartFile multipartFile : files) {
				try {
					messageBodyPath = setMultipathAttachments(multipartFile, messageBodyPath);
					multipart.addBodyPart(messageBodyPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			for (String docCode : docCodes) {
				DocumentationDTO document = new DocumentationDTO();
				document.setSearchKeyword(docCode);
				document.setFindMethod("code");
				List<Documentation> targetDocument = documentService.findDocument(document);
				if(targetDocument.size() > 1) throw new Exception("Error");
				messageBodyPath = setByteArrAttachments(targetDocument.get(0), messageBodyPath);
				multipart.addBodyPart(messageBodyPath);
			}
			
			message.setContent(multipart);  	
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private BodyPart setByteArrAttachments(Documentation document, BodyPart messageBodyPath) throws MessagingException {
		messageBodyPath = new MimeBodyPart();
		ByteArrayDataSource bds = new ByteArrayDataSource(document.getSource(), document.getType());
		messageBodyPath.setDataHandler(new DataHandler(bds));
		messageBodyPath.setFileName(document.getName());
		return messageBodyPath;
	}
	
	private BodyPart setMultipathAttachments(MultipartFile file, BodyPart messageBodyPath) throws MessagingException, IOException {
		messageBodyPath = new MimeBodyPart();
		ByteArrayDataSource bds = new ByteArrayDataSource(file.getBytes(), file.getContentType());
		messageBodyPath.setDataHandler(new DataHandler(bds));
		messageBodyPath.setFileName(file.getOriginalFilename());
		return messageBodyPath;
	}
	
	private Session getAuthenicationSession(String username, String password, Properties props) {
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}
	
	private Properties getEmailProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		return props;
	}

}
