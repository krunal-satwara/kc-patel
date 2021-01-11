package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {

    List<ContactPerson> findAllByMobileNoContainsOrContactPersonNameContainsOrEmailIdContains(String mobileNo, String contactPersonName, String emailId);

}
