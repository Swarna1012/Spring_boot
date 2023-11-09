package com.example.demo.JWT.service;

import com.example.demo.JWT.common.APIResponse;
import com.example.demo.JWT.dto.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails emailDetails);
}
