package com.ipn.mx.eventapp.application.services.impl;

import com.ipn.mx.eventapp.application.services.EmailService;
import com.ipn.mx.eventapp.domain.entities.AssistantEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    
    private final JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String fromEmail;
    
    @Value("${app.email.subject.prefix:Event Registration}")
    private String subjectPrefix;
    
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    @Async
    @Override
    public void sendRegistrationConfirmation(AssistantEntity assistant) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(assistant.getEmail());
            message.setSubject(subjectPrefix + " - Registration Confirmation");
            message.setText(buildEmailContent(assistant));
            
            mailSender.send(message);
            System.out.println("Confirmation email sent to: " + assistant.getEmail());
        } catch (Exception e) {
            System.err.println("Failed to send email to: " + assistant.getEmail() + ", Error: " + e.getMessage());
        }
    }
    
    private String buildEmailContent(AssistantEntity assistant) {
        return String.format(
		        """
				        Dear %s %s %s,
				        
				        Thank you for registering for our event!
				        
				        Your registration has been confirmed.
				        
				        Best regards,
				        Event Team""",
            assistant.getName(),
            assistant.getPaternalSurname(),
            assistant.getMaternalSurname()
        );
    }
}
