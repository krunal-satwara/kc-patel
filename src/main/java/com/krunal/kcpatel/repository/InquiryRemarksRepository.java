package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.InquiryRemarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRemarksRepository extends JpaRepository<InquiryRemarks, Long> {

    List<InquiryRemarks> findAllByStatusIsTrueAndInquiryId(Long inquiryId);

    InquiryRemarks findByInquiryRemarksId(Long inquiryRemarksId);

}
