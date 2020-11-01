package com.krunal.kcpatel.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class NavigationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long navigationMasterId;
    private String navigationUrl;
    private String displayName;
}
