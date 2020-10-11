package com.krunal.kcpatel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.Random;

@Service
public class CommonServices {

    @Value("${mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStarttlsEnable;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.smtp.port}")
    private String mailSmtpPort;

    @Value("${sms.service.provider}")
    private String smsServiceProviderUrl;

    public ResponseEntity<String> sendEmailForInquiry(String emailRecipient, String emailSubject, String emailMessage, String userEmail, String userPassword) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.port", mailSmtpPort);

        String ownerEmail = userEmail;
        String ownerPassword = userPassword;

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ownerEmail, ownerPassword);
            }
        });

        Message mailMessage = prepareMessage(session, ownerEmail, emailRecipient, emailSubject, emailMessage);
        Transport.send(mailMessage);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Message prepareMessage(Session session, String ownerEmail, String receipient, String subjectOfMail, String mailBody) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ownerEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipient));
            message.setSubject(subjectOfMail);
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(mailBody);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            return message;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void sendSms(String numbers, String message) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            String requestUrl = smsServiceProviderUrl + numbers + "&msgtype=TXT&message=" + message ;
            System.out.println("Sms Response =" + restTemplateUtil(requestUrl, HttpMethod.GET, entity));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String restTemplateUtil(String serviceUrl, HttpMethod method, HttpEntity<?> entity) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, method, entity, String.class);
            return responseEntity.getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public char[] OTP(int optLength) {
        // Using numeric values
        String numbers = "0123456789";
        // Using random method
        Random rndm_method = new Random();
        char[] otp = new char[optLength];
        for (int i = 0; i < optLength; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }

}
