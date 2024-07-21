package com.dashoshiv.EmailSender;

import com.dashoshiv.EmailSender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){

        System.out.println("Sending Email");
        emailService.sendEmail("shivansh.dashore2003@gmail.com","Demo second email from SpringBoot","This email is sent using JavaMailSender");
    }

    @Test
    void sendHtmlInEmailTest(){
        String htmlContent = ""+
               "<h1 style='color: red;border: 1px dashed red;'>Hi There</h1>"
                + "<h2 style='color: blue;'>Welcome to learning with Durgesh</h2>";

        emailService.sendEmailWithHtml("shivansh.dashore2003@gmail.com","Demo Third email from SpringBoot",htmlContent);
    }
    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile(
                "shivansh.dashore2003@gmail.com",
                "Demo fourth email from SpringBoot",
                "This email is sent using JavaMailSender",
                new File("D:\\Springboot_learn\\EmailSender\\EmailSender\\src\\main\\resources\\static\\myfiles\\Transcript.jpeg")
        );
    }
    @Test
    void sendEmailWithFileWithStream(){

        File file = new File("D:\\Springboot_learn\\EmailSender\\EmailSender\\src\\main\\resources\\static\\myfiles\\passportphoto.jpeg");
        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile(
                    "shivansh.dashore2003@gmail.com",
                    "Demo fifth email from SpringBoot",
                    "This email is sent using JavaMailSender",
                    is
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}