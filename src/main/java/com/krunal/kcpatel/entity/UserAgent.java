package com.krunal.kcpatel.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UserAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userAgentId;
    private Long agentId;
    private Long userId;
    private String agentCode;

    public UserAgent() {
    }

}
