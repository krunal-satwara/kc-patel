package com.krunal.kcpatel.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class SendEmailForInquiryConfigure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sendEmailForInquiryConfigId;
    private Long userId;
    private String userEmail;
    private String userPassword;
    private boolean status;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
