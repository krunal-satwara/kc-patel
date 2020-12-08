package com.krunal.kcpatel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long countryId;
    @Column(name = "name")
    private String countryName;
    @Column(name = "iso2")
    private String countryCode;
    @Column(name = "phonecode")
    private String phoneCode;
    @Column(name = "currency")
    private String currency;
}
