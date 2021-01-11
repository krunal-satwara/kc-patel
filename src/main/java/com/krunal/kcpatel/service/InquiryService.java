package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Inquiry;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InquiryService {

    ResponseEntity<String> inquiry(Inquiry inquiry);

    List<Inquiry> inquiries();

}
