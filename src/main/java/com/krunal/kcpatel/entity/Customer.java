package com.krunal.kcpatel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerName;
    private Long userId;
    private Long agentId;
    private String agentCode;
    private String address;
    private Long countryId;
    private Long stateId;
    private Long cityId;
    private String country;
    private String state;
    private String city;
    private String pinCode;
    private String website;
    private boolean status;
    private boolean customerStatus;
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER, orphanRemoval = true,targetEntity = ContactPerson.class)
    @JsonManagedReference
    private List<ContactPerson> contactPerson = new ArrayList<>();

}
