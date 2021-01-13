package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.InquiryRemarks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InquiryRemarksService {

    ResponseEntity<String> saveInquiryRemakrs(InquiryRemarks inquiryRemarks);

    List<InquiryRemarks> inquiryRemakrsList(Long inquiryId);

    InquiryRemarks inquiryRemakrs(Long inquiryRemarksId);

    ResponseEntity<String> deleteInquiryRemarks(Long inquiryRemarksId);
}
