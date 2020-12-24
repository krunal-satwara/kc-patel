package com.krunal.kcpatel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRemarks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerRemarksId;
    private Long customerId;
    private String customerRemarks;
    private Long userId;
    private String userName;
    private boolean status;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
