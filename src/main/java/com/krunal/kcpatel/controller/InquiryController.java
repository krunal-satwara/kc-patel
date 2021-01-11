package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Inquiry;
import com.krunal.kcpatel.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveInquiry(@RequestBody Inquiry inquiry) {
        return inquiryService.inquiry(inquiry);
    }

    @GetMapping("/list")
    public List<Inquiry> inquiries() {
        return inquiryService.inquiries();
    }
}
