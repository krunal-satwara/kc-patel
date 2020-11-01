package com.krunal.kcpatel.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class UserNavigation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNavigationId;
    private Long navigationMasterId;
    private Long userId;
    private String navigationUrl;
    private String displayName;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
