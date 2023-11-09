package com.example.demo.JWT.controller;

import com.example.demo.JWT.common.APIResponse;
import com.example.demo.JWT.dto.EmailDetails;
import com.example.demo.JWT.entity.User;
import com.example.demo.JWT.service.EmailService;
import com.example.demo.JWT.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/all")
    public APIResponse getUsers(Pageable pageable) {
        APIResponse apiResponse = pageService.getUsers(pageable);

        return apiResponse;
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        String status = emailService.sendSimpleMail(emailDetails);
        return status;
    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadImage = pageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable String filename){
        byte[] imageData = pageService.downloadImage(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageData);
    }
}
