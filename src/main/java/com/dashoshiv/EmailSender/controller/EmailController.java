package com.dashoshiv.EmailSender.controller;

import com.dashoshiv.EmailSender.response.CustomResponse;
import com.dashoshiv.EmailSender.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

        @Autowired
        private EmailService emailService;

    //send email api
    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        emailService.sendEmailWithHtml(request.getTo(),request.getSubject(),request.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Sent Successfully!!")
        );
    }
}