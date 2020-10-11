package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.SendEmailForInquiry;
import com.krunal.kcpatel.service.SendEmailForInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sendEmailForInquiry")
public class SendEmailForInquiryController {

    @Autowired
    private SendEmailForInquiryService sendEmailForInquiryService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody SendEmailForInquiry sendEmailForInquiry) {
        return sendEmailForInquiryService.saveSendEmailForInquiry(sendEmailForInquiry);
    }

    @GetMapping("/sendEmailForInquiryList")
    public List<SendEmailForInquiry> sendEmailForInquiryList() {
        return sendEmailForInquiryService.sendEmailForInquiryList();
    }

}
