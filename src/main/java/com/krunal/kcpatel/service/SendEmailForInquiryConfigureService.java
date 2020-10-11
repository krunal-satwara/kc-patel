package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.SendEmailForInquiryConfigure;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SendEmailForInquiryConfigureService {

    ResponseEntity<String> saveSendMailForInquiryConfigure(SendEmailForInquiryConfigure sendEmailForInquiryConfigure);

    ResponseEntity<String> deleteSendMailForInquiryConfigure(Long sendEmailForInquiryConfigId);

    ResponseEntity<String> updateSendEmailForInquiryConfigure(SendEmailForInquiryConfigure sendEmailForInquiryConfigure);

    List<SendEmailForInquiryConfigure> sendEmailForInquiryConfigureList();

}
