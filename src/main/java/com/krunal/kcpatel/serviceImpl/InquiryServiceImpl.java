package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.*;
import com.krunal.kcpatel.repository.AgentRepository;
import com.krunal.kcpatel.repository.InquiryDocumentRepository;
import com.krunal.kcpatel.repository.InquiryRepository;
import com.krunal.kcpatel.repository.UserRepository;
import com.krunal.kcpatel.service.InquiryService;
import com.krunal.kcpatel.service.SendEmailForInquiryService;
import com.krunal.kcpatel.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {


    @Autowired
    private InquiryRepository inquiryRepository;

    @Autowired
    private InquiryDocumentRepository inquiryDocumentRepository;

    @Autowired
    private SmsService smsService;

    @Autowired
    private SendEmailForInquiryService sendEmailForInquiryService;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${inquiry.file.upload.path}")
    private String inquiryFileUploadPath;

    @Override
    public ResponseEntity<String> inquiry(Inquiry inquiry) {
        try {

            ArrayList<String> agentIdList = new ArrayList<>(Arrays.asList(inquiry.getAgentId().split(",")));
            String agentCode = "";
            for (String agentId : agentIdList) {
                Agent agent = agentRepository.findByAgentId(Long.parseLong(agentId));
                agentCode += agent.getAgentCode() + ", ";
            }
            inquiry.setAgentCode(agentCode);

            User user = userRepository.findByUserId(inquiry.getUserId());
            inquiry.setUserName(user.getFirstName());

            inquiryRepository.save(inquiry);

            /*send sms to inquiry person*/
            if (inquiry.isSendSms() == true) {
                Sms sms = new Sms();
                sms.setSendTo(inquiry.getMobileNumber());
                sms.setSendType("TXT");
                sms.setMessage("Thanks " + inquiry.getContactPersonName() + " For Contacting K.C.Patel Company. We will work on your request and get back to you soon.");
                smsService.saveSms(sms);
            }

            /*send sms to inquiry person*/
            String emailId = inquiry.getEmailId();
            if (inquiry.isSendEmail() == true && !emailId.equals("") && emailId != null) {
                SendEmailForInquiry sendEmailForInquiry = new SendEmailForInquiry();
                sendEmailForInquiry.setEmailSubject("K.C.Patel");
                sendEmailForInquiry.setEmailRecipient(emailId);
                sendEmailForInquiry.setUserId(inquiry.getUserId());
                sendEmailForInquiry.setStatus(true);
                sendEmailForInquiry.setEmailMessage("Thanks For Contacting K.C.Patel & Company. We will work on your request and get back to you.");
                sendEmailForInquiryService.saveSendEmailForInquiry(sendEmailForInquiry);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<Inquiry> inquiries() {
        try {
            return inquiryRepository.findAllByInquiryStatusIsTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long inquiryId) {
        try {
            Inquiry inquiry = inquiryRepository.findByInquiryId(inquiryId);
            inquiry.setInquiryStatus(false);
            inquiryRepository.save(inquiry);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> activeDeactiveInquiry(Long inquiryId) {
        try {
            Inquiry inquiry = inquiryRepository.findByInquiryId(inquiryId);
            if (inquiry.isStatus() == false) {
                inquiry.setStatus(true);
            } else {
                inquiry.setStatus(false);
            }
            inquiryRepository.save(inquiry);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> fileUpload(MultipartFile file, Long inquiryId) {
        try {
            File fileObject = new File(inquiryFileUploadPath + File.separator + inquiryId);
            if (!fileObject.exists()) {
                fileObject.mkdir();
            }
            String tempuploadFolder = fileObject.getAbsolutePath() + File.separator;

            byte[] bytes = file.getBytes();
            Path path = Paths.get(tempuploadFolder + File.separator + file.getOriginalFilename());

            Files.write(path, bytes);
            InquiryDocument inquiryDocument = new InquiryDocument();
            inquiryDocument.setInquiryId(inquiryId);
            inquiryDocument.setDocumentName(file.getOriginalFilename().toString());
            inquiryDocument.setDocumentPath(path.toString());
            inquiryDocument.setDocumentSize(file.getSize());

            List<InquiryDocument> inquiryDocuments = inquiryDocumentRepository.findAllByInquiryIdAndDocumentStatusIsTrue(inquiryId);
            for (InquiryDocument inquiryDocument1 : inquiryDocuments) {
                if (inquiryDocument.getDocumentName().equals(inquiryDocument1.getDocumentName())) {
                    return new ResponseEntity<>(HttpStatus.IM_USED);
                }
            }
            inquiryDocumentRepository.save(inquiryDocument);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<InquiryDocument> inquiryDocuments(Long inquiryId) {
        return inquiryDocumentRepository.findAllByInquiryIdAndDocumentStatusIsTrue(inquiryId);
    }

    @Override
    public void deleteInquiryDocument(Long inquityDocumentId) {
        try {
            InquiryDocument inquiryDocument = inquiryDocumentRepository.findByInquiryDocumentId(inquityDocumentId);
            inquiryDocument.setDocumentStatus(false);
            inquiryDocumentRepository.save(inquiryDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
