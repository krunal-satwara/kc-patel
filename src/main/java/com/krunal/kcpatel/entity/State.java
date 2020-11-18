package com.krunal.kcpatel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stateId;
    private String stateName;
}
