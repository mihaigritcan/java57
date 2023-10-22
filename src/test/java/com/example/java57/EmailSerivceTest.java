package com.example.java57;

import com.example.java57.model.EmailSender;
import com.example.java57.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class EmailSerivceTest {

    @BeforeEach
    void printMessage(){
        System.out.println("Urmeaza un test!");
    }

    @Test
    void testeSendEmail(){
        EmailSender emailSenderMock=mock(EmailSender.class);
        EmailService emailServiceMock=new EmailService(emailSenderMock);
        emailServiceMock.sendEmail("teste@gmail.com","testul 1","Sunt bogat");
        verify(emailSenderMock,times(1)).send(anyString(),anyString(),anyString());
    }

}
