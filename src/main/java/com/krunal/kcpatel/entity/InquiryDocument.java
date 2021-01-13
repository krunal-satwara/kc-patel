package com.krunal.kcpatel.entity;

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
public class InquiryDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inquiryDocumentId;
    private Long inquiryId;
    private Long userId;
    private String documentPath;
    private String documentName;
    private double documentSize;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @Column(columnDefinition = "boolean default true")
    private boolean documentStatus = true;

}
