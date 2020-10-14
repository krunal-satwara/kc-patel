package com.krunal.kcpatel.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class UserOtp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long otpId;
    private Long userId;
    private String userEmail;
    private String otp;
    private boolean send;
    private boolean matched;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
