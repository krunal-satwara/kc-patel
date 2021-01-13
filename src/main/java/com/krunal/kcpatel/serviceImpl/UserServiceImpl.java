package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.Sms;
import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.entity.UserOtp;
import com.krunal.kcpatel.repository.OtpRepository;
import com.krunal.kcpatel.repository.UserRepository;
import com.krunal.kcpatel.service.CommonServices;
import com.krunal.kcpatel.service.SmsService;
import com.krunal.kcpatel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private CommonServices commonServices;

    @Value("${otp.length}")
    private int optLength;

    @Autowired
    private SmsService smsService;

    @Override
    public ResponseEntity<String> saveUser(User user) {
        try {
            user.setUserPassword(encoder.encode(user.getUserPassword()));
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateUser(User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public User getUser(Long userId) {
        try {
            return userRepository.findByUserId(userId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> users() {
        try {
            return userRepository.findAllByStatusIsTrueAndDeleteStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deactiveUser(Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            user.setStatus(false);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<User> allUsers() {
        try {
            return userRepository.findAllByDeleteStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> activeUser(Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            user.setStatus(true);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            user.setDeleteStatus(true);
            user.setStatus(false);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<User> deactiveUsers() {
        try {
            return userRepository.findAllByStatusIsFalseAndDeleteStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;

    }

    @Override
    public List<User> deletedUsers() {
        try {
            return userRepository.findAllByDeleteStatusIsTrue();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public String generateOTP() {
        try {
            return commonServices.OTP(optLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> forgotPassword(String userEmail) {
        try {
            User user = userRepository.findByUserEmailAndStatusIsTrue(userEmail);
            UserOtp userOtp = new UserOtp();
            userOtp.setUserId(user.getUserId());
            userOtp.setUserEmail(user.getUserEmail());
            String generatedOTP = generateOTP();
            userOtp.setOtp(generatedOTP);
            userOtp.setSend(true);
            userOtp.setMatched(false);
            otpRepository.save(userOtp);
            Sms sms = new Sms();
            sms.setSendTo(user.getUserMobile().toString());
            sms.setMessage("Reset Password OTP:" + userOtp.getOtp());
            sms.setSendType("TXT");
            smsService.saveSms(sms);
            return new ResponseEntity<>(user.getUserId().toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Object userEmailExist(String userEmail) {
        try {
            User user = userRepository.findByUserEmailAndStatusIsTrue(userEmail);
            if (user != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Object userEmailExistCheckForUpdate(String userEmail, Long userId) {
        try {
            User user = userRepository.findByUserEmailAndStatusIsTrueAndUserIdIsNot(userEmail, userId);
            if (user != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> confirmOtp(String userEmail, String otp) {
        try {
            UserOtp userOtp1 = otpRepository.findByUserEmailIsAndOtpIsAndMatchedIsFalse(userEmail, otp);
            if (userOtp1 != null) {
                userOtp1.setMatched(true);
                otpRepository.save(userOtp1);
                return new ResponseEntity<>(userOtp1.getUserId().toString(), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
