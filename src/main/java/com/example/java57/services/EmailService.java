package com.example.java57.services;

import com.example.java57.model.EmailSender;

public class EmailService {
    private EmailSender emailSender;

    public EmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
    public void sendEmail(String to, String subject, String message){
        this.emailSender.send(to,subject,message);
    }
}
