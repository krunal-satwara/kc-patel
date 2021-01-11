package com.krunal.kcpatel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inquiryId;
    private Long userId;
    private String userName;
    private String agentId;
    private String agentCode;
    private String contactPersonName;
    private String mobileNumber;
    private String emailId;
    private Long countryId;
    private String countryName;
    private Long stateId;
    private String stateName;
    private Long cityId;
    private String cityName;
    private String inquiryThrough;
    private boolean sendEmail;
    private boolean sendSms;
    private String notes;
    private boolean status;
    private boolean inquiryStatus;
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
