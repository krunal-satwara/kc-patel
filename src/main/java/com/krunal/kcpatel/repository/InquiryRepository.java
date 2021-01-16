package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    List<Inquiry> findAllByInquiryStatusIsTrue();

    Inquiry findByInquiryId(Long inquiryId);

    @Query(value = "SELECT max(`inquiry_no`) from kcpatel.`inquiry`",nativeQuery = true)
    Long inquiryNoGenerate();
}
