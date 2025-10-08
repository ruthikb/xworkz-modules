package com.petShop.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.awt.SystemColor.text;

@Component
public class OtpGenerator {

    @Autowired
    JavaMailSender javaMailSender;
    public  String generateOtp() {
        Random random = new Random();
    int i1=random.nextInt(999999);
        String s= String.valueOf(i1);
        return s;
    }

        public String  sendSimpleMessage(String email) {

            SimpleMailMessage message = new SimpleMailMessage();
            String otp = generateOtp();
            message.setFrom("kruthik693@gmail.com.com");
            message.setTo(email);
            message.setSubject("");
            message.setText(otp);
            javaMailSender.send(message);
            return  otp;
        }

}
