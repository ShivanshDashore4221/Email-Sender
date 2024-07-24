package com.dashoshiv.EmailSender.controller;

import com.dashoshiv.EmailSender.response.CustomResponse;
import com.dashoshiv.EmailSender.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
                CustomResponse.builder().message("Email Sent Successfully!!").httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendWithFile(@RequestPart EmailRequest request, @RequestPart MultipartFile file) throws IOException {
        emailService.sendEmailWithFile(request.getTo(),request.getSubject(), request.getMessage(), file.getInputStream());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Sent Successfully!!").httpStatus(HttpStatus.OK).success(true).build()
        );

    }
}