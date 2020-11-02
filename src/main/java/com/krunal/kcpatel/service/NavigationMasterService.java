package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.NavigationMaster;

import java.util.List;

public interface NavigationMasterService {
    List<NavigationMaster> navigationMasterList();

    List<NavigationMaster> filteredNavigationMasterList(Long userId);
}
