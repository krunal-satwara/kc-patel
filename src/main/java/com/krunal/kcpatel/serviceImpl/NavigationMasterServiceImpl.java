package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.NavigationMaster;
import com.krunal.kcpatel.entity.UserNavigation;
import com.krunal.kcpatel.repository.NavigationMasterRepository;
import com.krunal.kcpatel.service.NavigationMasterService;
import com.krunal.kcpatel.service.UserNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationMasterServiceImpl implements NavigationMasterService {

    @Autowired
    private NavigationMasterRepository navigationMasterRepository;

    @Autowired
    private UserNavigationService userNavigationService;

    @Override
    public List<NavigationMaster> navigationMasterList() {
        return navigationMasterRepository.findAll();
    }

    @Override
    public List<NavigationMaster> filteredNavigationMasterList(Long userId) {
        try {
            List<NavigationMaster> navigationMasterList = navigationMasterList();
            List<UserNavigation> navigationList = userNavigationService.userSavedNavigationList(userId);
            List<NavigationMaster> filteredNavigationMasterList = new ArrayList<>();
            filteredNavigationMasterList.addAll(navigationMasterList);
            for (UserNavigation userNavigation : navigationList) {
                NavigationMaster navigationMaster = new NavigationMaster();
                navigationMaster.setNavigationMasterId(userNavigation.getNavigationMasterId());
                navigationMaster.setDisplayName(userNavigation.getDisplayName());
                navigationMaster.setNavigationUrl(userNavigation.getNavigationUrl());
                for (NavigationMaster navigationMaster1 : navigationMasterList) {
                    if (navigationMaster1.getNavigationMasterId() == userNavigation.getNavigationMasterId()) {
                        filteredNavigationMasterList.remove(navigationMaster);
                    }
                }
            }
            return filteredNavigationMasterList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
