package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Inquiry;
import com.krunal.kcpatel.entity.InquiryDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InquiryService {

    ResponseEntity<String> inquiry(Inquiry inquiry);

    List<Inquiry> inquiries();

    ResponseEntity<String> delete(Long inquiryId);

    ResponseEntity<String> activeDeactiveInquiry(Long inquiryId);

    ResponseEntity<String> fileUpload(MultipartFile file, Long inquiryId);

    List<InquiryDocument> inquiryDocuments(Long inquiryId);

    void deleteInquiryDocument(Long inquityDocumentId);

}
