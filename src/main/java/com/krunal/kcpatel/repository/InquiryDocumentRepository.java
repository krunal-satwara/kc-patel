package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.InquiryDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryDocumentRepository extends JpaRepository<InquiryDocument, Long> {

    List<InquiryDocument> findAllByInquiryIdAndDocumentStatusIsTrue(Long inquiryId);

    InquiryDocument findByInquiryDocumentId(Long inquiryDocumentId);
}
