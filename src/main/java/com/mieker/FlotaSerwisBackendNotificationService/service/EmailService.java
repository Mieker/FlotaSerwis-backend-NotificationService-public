package com.mieker.FlotaSerwisBackendNotificationService.service;

import com.mieker.FlotaSerwisBackendNotificationService.model.EmailDto;

import javax.mail.MessagingException;

public interface EmailService {

    void sendEmail(EmailDto emailDto) throws MessagingException;
}
