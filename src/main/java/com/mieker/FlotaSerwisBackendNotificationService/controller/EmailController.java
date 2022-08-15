package com.mieker.FlotaSerwisBackendNotificationService.controller;

import com.mieker.FlotaSerwisBackendNotificationService.model.EmailDto;
import com.mieker.FlotaSerwisBackendNotificationService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto) {
        try {
            emailService.sendEmail(emailDto);
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wiadomość do "
                    + emailDto.getEmail() + " nie została wysłana!");

        }
        return ResponseEntity.ok("Wysłano email do: " + emailDto.getEmail());
    }
}
