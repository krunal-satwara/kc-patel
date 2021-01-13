package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.InquiryRemarks;
import com.krunal.kcpatel.service.InquiryRemarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiryRemarks")
public class InquiryRemarksController {

    @Autowired
    private InquiryRemarksService inquiryRemarksService;

    @PostMapping("/save")
    public ResponseEntity<String> saveInquiryRemarks(@RequestBody InquiryRemarks inquiryRemarks) {
        return inquiryRemarksService.saveInquiryRemakrs(inquiryRemarks);
    }

    @GetMapping("/list/{inquiryId}")
    public List<InquiryRemarks> inquiryRemakrsList(@PathVariable("inquiryId") Long inquiryId) {
        return inquiryRemarksService.inquiryRemakrsList(inquiryId);
    }

    @DeleteMapping("/delete/{inquiryRemarksId}")
    public ResponseEntity<String> deleteInquiryRemarks(@PathVariable("inquiryRemarksId") Long inquiryRemarksId) {
        return inquiryRemarksService.deleteInquiryRemarks(inquiryRemarksId);
    }

    @GetMapping("/{inquiryRemarksId}")
    public InquiryRemarks inquiryRemarks(@PathVariable("inquiryRemarksId") Long inquiryRemarksId) {
        return inquiryRemarksService.inquiryRemakrs(inquiryRemarksId);
    }
}
