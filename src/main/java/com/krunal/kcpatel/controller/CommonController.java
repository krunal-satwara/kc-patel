package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Cities;
import com.krunal.kcpatel.entity.Countries;
import com.krunal.kcpatel.entity.States;
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

    @GetMapping("/countries")
    public List<Countries> countriesList() {
        return commonServices.countriesList();
    }

    @GetMapping("/countryWiseStateList/{countryId}")
    public List<States> countryWiseStateList(@PathVariable("countryId") Long countryId) {
        return commonServices.countryWiseStateList(countryId);
    }

    @GetMapping("/stateWiseCityList/{stateId}")
    public List<Cities> stateWiseCityList(@PathVariable("stateId") Long stateId) {
        return commonServices.stateWiseCityList(stateId);
    }
}
