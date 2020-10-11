package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.SendEmailForInquiry;
import com.krunal.kcpatel.entity.SendEmailForInquiryConfigure;
import com.krunal.kcpatel.repository.SendEmailForInquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendEmailForInquiryServiceImpl implements SendEmailForInquiryService {

    @Autowired
    private SendEmailForInquiryRepository sendEmailForInquiryRepository;

    @Autowired
    private SendEmailForInquiryConfigureService sendEmailForInquiryConfigureService;

    @Autowired
    private CommonServices commonServices;

    @Override
    public ResponseEntity<String> saveSendEmailForInquiry(SendEmailForInquiry sendEmailForInquiry) {
        try {

            List<SendEmailForInquiryConfigure> sendEmailForInquiryConfigureList = sendEmailForInquiryConfigureService.sendEmailForInquiryConfigureList();
            SendEmailForInquiryConfigure sendEmailForInquiryConfigure = sendEmailForInquiryConfigureList.get(0);

            commonServices.sendEmailForInquiry(sendEmailForInquiry.getEmailRecipient(), sendEmailForInquiry.getEmailSubject(),
                    sendEmailForInquiry.getEmailMessage(), sendEmailForInquiryConfigure.getUserEmail(),
                    sendEmailForInquiryConfigure.getUserPassword());

            sendEmailForInquiry.setEmailFrom(sendEmailForInquiryConfigure.getUserEmail());
            sendEmailForInquiry.setSendEmailForInquiryConfigId(sendEmailForInquiryConfigure.getSendEmailForInquiryConfigId());
            sendEmailForInquiryRepository.save(sendEmailForInquiry);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<SendEmailForInquiry> sendEmailForInquiryList() {
        try {
            return sendEmailForInquiryRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
