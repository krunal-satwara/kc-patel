package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.SendEmailForInquiryConfigure;
import com.krunal.kcpatel.repository.SendEmailForInquiryConfigureRepository;
import com.krunal.kcpatel.service.SendEmailForInquiryConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendEmailForInquiryConfigureServiceImpl implements SendEmailForInquiryConfigureService {


    @Autowired
    private SendEmailForInquiryConfigureRepository sendEmailForInquiryConfigureRepository;

    @Override
    public ResponseEntity<String> saveSendMailForInquiryConfigure(SendEmailForInquiryConfigure sendEmailForInquiryConfigure) {
        try {
            List<SendEmailForInquiryConfigure> sendEmailForInquiryConfigureList = sendEmailForInquiryConfigureRepository.findAllByStatusIsTrue();
            if (sendEmailForInquiryConfigureList != null && !sendEmailForInquiryConfigureList.isEmpty()) {
                for (SendEmailForInquiryConfigure forInquiryConfigure : sendEmailForInquiryConfigureList) {
                    forInquiryConfigure.setStatus(false);
                    sendEmailForInquiryConfigureRepository.save(forInquiryConfigure);
                }
            }
            sendEmailForInquiryConfigureRepository.save(sendEmailForInquiryConfigure);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteSendMailForInquiryConfigure(Long sendEmailForInquiryConfigId) {
        try {
            SendEmailForInquiryConfigure sendEmailForInquiryConfigure = sendEmailForInquiryConfigureRepository.findBySendEmailForInquiryConfigId(sendEmailForInquiryConfigId);
            sendEmailForInquiryConfigure.setStatus(false);
            sendEmailForInquiryConfigureRepository.save(sendEmailForInquiryConfigure);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateSendEmailForInquiryConfigure(SendEmailForInquiryConfigure sendEmailForInquiryConfigure) {
        try {
            sendEmailForInquiryConfigureRepository.save(sendEmailForInquiryConfigure);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<SendEmailForInquiryConfigure> sendEmailForInquiryConfigureList() {
        try {
            return sendEmailForInquiryConfigureRepository.findAllByStatusIsTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
