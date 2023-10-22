package com.example.java57.model;

public class EmailSender {
    private String to;
    private String subject;
    private String message;

    public void send(String to, String subject, String message){
        this.to=to;
        this.subject=subject;
        this.message=message;
        System.out.println(to+" "+subject+" "+message);
    }
}
