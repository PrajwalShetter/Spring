package com.xworkz.common.service.impl;

import com.xworkz.common.dto.LoginDto;
import com.xworkz.common.dto.UserDto;
import com.xworkz.common.entity.LoginEntity;
import com.xworkz.common.entity.UserEntity;
import com.xworkz.common.repository.LoginRepo;
import com.xworkz.common.repository.UserRepo;
import com.xworkz.common.service.LoginService;
import com.xworkz.common.utils.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @Autowired
    UserRepo userRepo;

    @Override
    public String saveLogin(LoginDto loginDto) {
        System.out.println("Login service reached");
        String result = passwordMatch(loginDto.getEmail(),loginDto.getPassword());
        System.out.println("Password checked result :"+result);
        if(result.equals("Password Matched")){
            LoginEntity loginEntity = new LoginEntity();
            BeanUtils.copyProperties(loginDto,loginEntity);
            boolean save = loginRepo.saveLogin(loginEntity);
            if(save){
                return "login saved successfully into DB";
            }else {
                return "login not saved into DB";
            }
        }
        return result;
    }

    @Override
    public String passwordMatch(String email,String password) {
        System.out.println("passwordMatch method reached");
        UserDto user = userService.findByEmail(email);
        System.out.println("User fetched :"+user);

        if(user == null){
            return "Email does not Exist";
        }

        if(Boolean.FALSE.equals(user.getStatus())){
            return "Account is Blocked. please reset the password";
        }
        if(passwordEncoder.matches(password, user.getPassword() )){

            if(user.getCount()!= null && user.getCount()>0){
                user.setCount(0);

                boolean update= userService.updateUser(user);

                if(!update){
                    return "unable to update the account";
                }
            }

            return "Password Matched";
        }
        else{
            int count ;

            if(user.getCount()==null) {
                count = 0;
            }
            else {
                count= user.getCount();
            }
            if(count <3){
                count++;
            }

                user.setCount(count);

                if(count>=3){
                    user.setStatus(false);
                }
                boolean update = userService.updateUser(user);

                if(!update){
                    return "unable to update the account details";
                }

                if(count >=3){
                    return "Account is Blocked. please reset the password";
                }
                 return "Password is incorrect. Attempts remaining :"+(3-count);
            }

        }

    @Override
    public String sendOtp(String email) {
        UserEntity user = userRepo.findByEmail(email);

        if(user == null){
            return "Email not found";
        }

        Integer randomNumber = emailService.getRandomNumber();
        String otp = String.valueOf(randomNumber);
        String encodedOtp = passwordEncoder.encode(otp);
        user.setOtp(encodedOtp);
        boolean update = userRepo.updateUser(user);
        if(!update){
            return "unable to update user otp";
        }
        emailService.sendOtpEmail(otp, user.getEmail());
        return "otp send successfully";
    }

    @Override
    public String verifyOtp(String email, String otp) {
        UserEntity user = userRepo.findByEmail(email);

        if(user ==null){
            return "email not found";
        }
        if (user.getOtp() == null) {
            return "OTP not found. Please request a new OTP";
        }

        if(passwordEncoder.matches(otp, user.getOtp())){
            return "OTP Matched";
        }
        return "Wrong OTP";
    }

    @Override
    public String resetNewPassword(String email, String password, String ConfirmPassword) {
        UserDto user = userService.findByEmail(email);
        if(user == null){
            return "Email not Exist";
        }
        if (password == null || password.trim().isEmpty()) {
            return "Password cannot be empty";
        }

        if (!password.matches("^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,20}$")) {
            return "Password must contain 8–20 characters, "
                    + "1 uppercase letter and 1 symbol.";
        }
        if (!password.equals(ConfirmPassword)) {
            return "Passwords do not match.";
        }
        user.setPassword(passwordEncoder.encode(password));
        user.setStatus(true);
        user.setCount(0);
        user.setOtp(null);

        boolean update = userService.updateUser(user);

        if (!update) {
            return "Unable to update password";
        }

        return "Password Updated";
    }
}

