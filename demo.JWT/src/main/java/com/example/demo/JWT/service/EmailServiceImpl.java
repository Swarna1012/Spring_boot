package com.example.demo.JWT.service;

import com.example.demo.JWT.common.APIResponse;
import com.example.demo.JWT.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendSimpleMail(EmailDetails emailDetails) {

        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setSubject(emailDetails.getMsgBody());
            mailMessage.setText(emailDetails.getSubject());

            javaMailSender.send(mailMessage);

            return "Mail Sent Successfully...";
        }
        catch(Exception e) {
            return "Error While Sending Mail";
        }
    }

//    @Autowired
//    public EmailService(JavaMailSender javaMailSender){
//
//    }
//    public void sendMail(String to, String subject, String body){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//
//        javaMailSender.send(message);
//    }

}
