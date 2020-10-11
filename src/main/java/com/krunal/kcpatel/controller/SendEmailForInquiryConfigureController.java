package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.SendEmailForInquiryConfigure;
import com.krunal.kcpatel.service.SendEmailForInquiryConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sendEmailForInquiryConfigure")
public class SendEmailForInquiryConfigureController {

    @Autowired
    private SendEmailForInquiryConfigureService sendEmailForInquiryConfigureService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSendMailForInquiryConfigure(@RequestBody SendEmailForInquiryConfigure sendEmailForInquiryConfigure){
        return sendEmailForInquiryConfigureService.saveSendMailForInquiryConfigure(sendEmailForInquiryConfigure);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSendEmailForInquiryConfigure(@RequestBody SendEmailForInquiryConfigure sendEmailForInquiryConfigure){
        return sendEmailForInquiryConfigureService.updateSendEmailForInquiryConfigure(sendEmailForInquiryConfigure);
    }

    @GetMapping("/sendEmailForInquiryConfigureList")
    public List<SendEmailForInquiryConfigure> sendEmailForInquiryConfigureList(){
        return sendEmailForInquiryConfigureService.sendEmailForInquiryConfigureList();
    }
}
