package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.Inquiry;
import com.krunal.kcpatel.entity.SendEmailForInquiry;
import com.krunal.kcpatel.entity.Sms;
import com.krunal.kcpatel.repository.InquiryRepository;
import com.krunal.kcpatel.service.InquiryService;
import com.krunal.kcpatel.service.SendEmailForInquiryService;
import com.krunal.kcpatel.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {


    @Autowired
    private InquiryRepository inquiryRepository;

    @Autowired
    private SmsService smsService;

    @Autowired private SendEmailForInquiryService sendEmailForInquiryService;

    @Override
    public ResponseEntity<String> inquiry(Inquiry inquiry) {
        try {

            inquiryRepository.save(inquiry);

            /*send sms to inquiry person*/
            if (inquiry.isSendSms() == true) {
                Sms sms = new Sms();
                sms.setSendTo(inquiry.getMobileNumber());
                sms.setSendType("TXT");
                sms.setMessage("Thanks For Contacting K.C.Patel Company. We will work on your request and get back to you soon.");
                smsService.saveSms(sms);
            }

            /*send sms to inquiry person*/
            String emailId = inquiry.getEmailId();
            if (inquiry.isSendEmail() == true && !emailId.equals("") && emailId != null) {
                SendEmailForInquiry sendEmailForInquiry = new SendEmailForInquiry();
                sendEmailForInquiry.setEmailSubject("K.C.Patel");
                sendEmailForInquiry.setEmailRecipient(emailId);
                sendEmailForInquiry.setUserId(inquiry.getUserId());
                sendEmailForInquiry.setStatus(true);
                sendEmailForInquiry.setEmailMessage("Thanks For Contacting K.C.Patel & Company. We will work on your request and get back to you.");
                sendEmailForInquiryService.saveSendEmailForInquiry(sendEmailForInquiry);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<Inquiry> inquiries() {
        try {
            return inquiryRepository.findAllByInquiryStatusIsTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
