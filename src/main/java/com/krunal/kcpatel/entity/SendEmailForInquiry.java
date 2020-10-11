package com.krunal.kcpatel.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class SendEmailForInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sendEmailForInquiryId;
    private Long userId;
    private Long sendEmailForInquiryConfigId;
    private String emailFrom;
    private String emailRecipient;
    private String emailSubject;
    private String emailMessage;
    private boolean status;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
