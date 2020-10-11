package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Sms;
import com.krunal.kcpatel.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSms(@RequestBody Sms sms) {
        return smsService.saveSms(sms);
    }

    @GetMapping("/history")
    public List<Sms> smsList() {
        return smsService.smsList();
    }
}
