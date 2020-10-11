package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.SendEmailForInquiryConfigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SendEmailForInquiryConfigureRepository extends JpaRepository<SendEmailForInquiryConfigure,Long> {

    List<SendEmailForInquiryConfigure> findAllByStatusIsTrue();

    SendEmailForInquiryConfigure findBySendEmailForInquiryConfigId(Long sendEmailForInquiryConfigId);
}
