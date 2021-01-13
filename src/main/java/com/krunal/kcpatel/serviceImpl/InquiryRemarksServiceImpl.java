package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.InquiryRemarks;
import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.repository.InquiryRemarksRepository;
import com.krunal.kcpatel.service.InquiryRemarksService;
import com.krunal.kcpatel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryRemarksServiceImpl implements InquiryRemarksService {

    @Autowired
    private InquiryRemarksRepository inquiryRemarksRepository;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<String> saveInquiryRemakrs(InquiryRemarks inquiryRemarks) {
        try {
            User user = userService.getUser(inquiryRemarks.getUserId());
            inquiryRemarks.setUserName(user.getFirstName());
            inquiryRemarksRepository.save(inquiryRemarks);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<InquiryRemarks> inquiryRemakrsList(Long inquiryId) {
        try {
            return inquiryRemarksRepository.findAllByStatusIsTrueAndInquiryId(inquiryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InquiryRemarks inquiryRemakrs(Long inquiryRemarksId) {
        try {
            return inquiryRemarksRepository.findByInquiryRemarksId(inquiryRemarksId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deleteInquiryRemarks(Long inquiryRemarksId) {
        try {
            InquiryRemarks inquiryRemarks = inquiryRemarksRepository.findByInquiryRemarksId(inquiryRemarksId);
            inquiryRemarks.setStatus(false);
            inquiryRemarksRepository.save(inquiryRemarks);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
