package com.sattaporn.service.impl;

import java.io.IOException;
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.model.Email;
import com.sattaporn.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendMail(MultipartFile[] files, Email email) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getUsername(), email.getPassword());
			}
		});
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
					messageBodyPath = new MimeBodyPart();
					ByteArrayDataSource bds = new ByteArrayDataSource(multipartFile.getBytes(), multipartFile.getContentType());
					messageBodyPath.setDataHandler(new DataHandler(bds));
					messageBodyPath.setFileName(multipartFile.getOriginalFilename());
					multipart.addBodyPart(messageBodyPath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			message.setContent(multipart);  	
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
