package com.mieker.FlotaSerwisBackendNotificationService.service;

import com.mieker.FlotaSerwisBackendNotificationService.model.EmailDto;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(EmailDto emailDto) throws MessagingException {
        sendEmail(emailDto.getEmail(), emailDto.getTitle(), emailDto.getBody());
    }

    private void sendEmail(String email, String title, String body) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(body, false);
        javaMailSender.send(mimeMessage);
    }
}
