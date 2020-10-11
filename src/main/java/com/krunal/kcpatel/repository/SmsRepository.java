package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsRepository extends JpaRepository<Sms, Long> {

}
