package com.dashoshiv.EmailSender.services;

import java.io.File;
import java.io.InputStream;
// interface created so that if we wish to change service from gmail to some other like outlook, then only implementation needs to be altered

public interface EmailService {
    // send email to single person
    void sendEmail(String to, String subject, String message);

    //send email to multiple people
    void sendEmail(String[] to, String subject, String message);

    // send email with html content
    void sendEmailWithHtml(String to, String subject, String htmlContent);

    // send email with file
    void sendEmailWithFile(String to, String subject, String message, File file);

    // send email with inputStream for uploading file from database or something
    void sendEmailWithFile(String to, String subject, String message, InputStream is);

}