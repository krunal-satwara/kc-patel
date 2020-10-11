package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Sms;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SmsService {

    ResponseEntity<String> saveSms(Sms sms);

    List<Sms> smsList();
}
