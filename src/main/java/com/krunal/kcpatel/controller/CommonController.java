package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.City;
import com.krunal.kcpatel.entity.State;
import com.krunal.kcpatel.service.CommonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonServices commonServices;

    @GetMapping("/stateList")
    public List<State> stateList() {
        return commonServices.stateList();
    }

    @GetMapping("/cityList")
    public List<City> cityList() {
        return commonServices.cityList();
    }

    @GetMapping("/stateWiseCityList/{stateId}")
    public List<City> stateWiseCityList(@PathVariable("stateId") Long stateId) {
        return commonServices.stateWiseCity(stateId);
    }
}
