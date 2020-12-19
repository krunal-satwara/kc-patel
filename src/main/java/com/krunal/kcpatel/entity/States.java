package com.krunal.kcpatel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long stateId;
    @Column(name = "name")
    private String stateName;
    private Long countryId;
    @Column(name = "iso2")
    private String countryCode;
}
