package com.xworkz.common.service;

import com.xworkz.common.dto.LoginDto;
import com.xworkz.common.entity.LoginEntity;

public interface LoginService {

     String saveLogin(LoginDto loginDto);
     String passwordMatch(String email, String password);
     String sendOtp(String email);
     String verifyOtp(String email, String otp);
     String resetPassword(String email, String password);

}
