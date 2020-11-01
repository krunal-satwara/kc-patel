package com.krunal.kcpatel.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class UserNavigationWrites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNavigationWriteId;
    private Long userNavigationId;
    private boolean view;
    private boolean edit;
    private boolean del;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
