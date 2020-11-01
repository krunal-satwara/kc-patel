package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.NavigationMaster;
import com.krunal.kcpatel.repository.NavigationMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationMasterServiceImpl implements NavigationMasterService {

    @Autowired
    private NavigationMasterRepository navigationMasterRepository;

    @Override
    public List<NavigationMaster> navigationMasterList() {
        return navigationMasterRepository.findAll();
    }
}
