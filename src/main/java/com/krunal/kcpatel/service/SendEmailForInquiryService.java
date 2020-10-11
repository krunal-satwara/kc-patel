package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.SendEmailForInquiry;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SendEmailForInquiryService {

    ResponseEntity<String> saveSendEmailForInquiry(SendEmailForInquiry sendEmailForInquiry);

    List<SendEmailForInquiry> sendEmailForInquiryList();
}
