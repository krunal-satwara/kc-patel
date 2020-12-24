/*
package com.krunal.kcpatel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CustomerAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerAgentId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customerId", nullable = false)
    @JsonBackReference
    private Customer customer;
    private Long agentId;
    private String agentCode;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
*/
