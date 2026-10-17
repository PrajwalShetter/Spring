package com.xworkz.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public Integer getRandomNumber(){
        Random random=new Random();
       return 100000+random.nextInt(900000);
    }

    public void sendOtpEmail(String otp,String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Password Reset mail");
        message.setText("Your Otp For reset password is : "+otp);
        message.setTo(email);
        javaMailSender.send(message);
    }
}
