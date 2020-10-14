package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.UserOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<UserOtp, Long> {

    UserOtp findByUserEmailIsAndOtpIsAndMatchedIsFalse(String userEmail, String otp);

}
