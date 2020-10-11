package com.krunal.kcpatel.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long smsId;
    private String sendTo;
    private String sendType;
    private String message;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
