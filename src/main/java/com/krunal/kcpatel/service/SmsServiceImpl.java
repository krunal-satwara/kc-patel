package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Sms;
import com.krunal.kcpatel.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsRepository smsRepository;

    @Autowired
    private CommonServices commonServices;

    @Value("${sms.service.flag}")
    private boolean smsServiceFlag;


    @Override
    public ResponseEntity<String> saveSms(Sms sms) {
        try {
            if (smsServiceFlag == true) {
                commonServices.sendSms(sms.getSendTo(), sms.getMessage());
            }
            smsRepository.save(sms);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<Sms> smsList() {
        try {
            return smsRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
