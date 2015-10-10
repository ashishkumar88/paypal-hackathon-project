package org.paypal.hackathon.project.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	private String senderAddress;
	private String recipient;
	private InputStreamSource attachment;
	private String fileName;
	private String emailSubject;
	private String emailContent;

	public InputStreamSource getAttachment() {
		return attachment;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public String getFileName() {
		return fileName;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void sendMail() {

		final MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
				mimeMessage.setFrom(new InternetAddress(senderAddress));
				mimeMessage.setSubject(emailSubject);
				mimeMessage.setContent(emailContent, "text/html");
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.addAttachment(fileName, attachment);
				helper.setText("Text in Email Body");
			}
		};
		try {
			mailSender.send(preparator);
		} catch (final MailException ex) {
		}
	}

	public void setAttachment(InputStreamSource attachment) {
		this.attachment = attachment;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
}