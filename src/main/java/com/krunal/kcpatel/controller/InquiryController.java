package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Inquiry;
import com.krunal.kcpatel.entity.InquiryDocument;
import com.krunal.kcpatel.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @Value("${inquiry.file.upload.path}")
    private String inquiryFileUploadPath;

    @PostMapping("/save")
    public ResponseEntity<String> saveInquiry(@RequestBody Inquiry inquiry) {
        return inquiryService.inquiry(inquiry);
    }

    @GetMapping("/list")
    public List<Inquiry> inquiries() {
        return inquiryService.inquiries();
    }

    @DeleteMapping("/delete/{inquiryId}")
    public ResponseEntity<String> delete(@PathVariable("inquiryId") Long inquiryId) {
        return inquiryService.delete(inquiryId);
    }

    @PostMapping("/activeDeactiveInquiry/{inquiryId}")
    public ResponseEntity<String> activeDeactiveInquiry(@PathVariable("inquiryId") Long inquiryId) {
        return inquiryService.activeDeactiveInquiry(inquiryId);
    }

    @PostMapping("/upload/{inquiryId}")
    public ResponseEntity<String> inquiryFileUpload(@RequestParam("file") MultipartFile file, @PathVariable("inquiryId") Long inquiryId) {
        return inquiryService.fileUpload(file, inquiryId);
    }

    @GetMapping("/inquiryDocuments/{inquiryId}")
    public List<InquiryDocument> inquiryDocuments(@PathVariable("inquiryId") Long inquiryId) {
        return inquiryService.inquiryDocuments(inquiryId);
    }

    @GetMapping("/inquiryDocumentDownload/{inquiryId}/{fileName}")
    public void downloadFile(@PathVariable("inquiryId") Long inquiryId, @PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.getOutputStream().write(contentOf(fileName, inquiryId));
    }

    private byte[] contentOf(String fileName, Long inquiryId) throws Exception {
        return Files.readAllBytes(Paths.get(inquiryFileUploadPath + inquiryId + "/" + fileName));
    }

    @DeleteMapping("/deleteInquiryDocument/{inquiryId}/{fileName}/{inquiryDocumentId}")
    public ResponseEntity<String> deleteInquiryDocument(@PathVariable("inquiryId") Long inquiryId, @PathVariable("fileName") String fileName, @PathVariable("inquiryDocumentId") Long inquiryDocumentId) {
        File file = new File(inquiryFileUploadPath + inquiryId + File.separator + fileName);
        if (file.delete()) {
            inquiryService.deleteInquiryDocument(inquiryDocumentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            inquiryService.deleteInquiryDocument(inquiryDocumentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/generateinquiryNo")
    public Long generateInquiryNo() {
        return inquiryService.generateInquiryNo();
    }
}
