package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.SendEmailForInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SendEmailForInquiryRepository extends JpaRepository<SendEmailForInquiry, Long> {

    SendEmailForInquiry findBySendEmailForInquiryId(Long emailId);

    List<SendEmailForInquiry> findAllByStatusIsTrue();
}
