package com.xworkz.common.controller;

import com.xworkz.common.service.LoginService;
import com.xworkz.common.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class PasswordOtpController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @GetMapping("reset")
    public String getResetPassword(@RequestParam(required = false) String email, Model model, HttpSession session ){
        String email1 = (String)session.getAttribute(email);
        model.addAttribute("email",email1);
        return "user/resetPassword";
    }

    @GetMapping("sendOtp")
    public String sendOtp(@RequestParam String email, Model model) {
        String result = loginService.sendOtp(email);
        System.out.println("OTP result: " + result);
        model.addAttribute("email", email);
        if (result.equalsIgnoreCase("otp send successfully")) {
            model.addAttribute("otpSent", true);
        } else {
            model.addAttribute("otpSent", false);
            model.addAttribute("failure", result);
        }
        return "user/resetPassword";
    }

    @PostMapping("verifyOtp")
    public String verifyOtp(@RequestParam String email, String otp, Model model, HttpSession session){
        String result = loginService.verifyOtp(email,otp);
        session.setAttribute("email",email);

        if(result.equalsIgnoreCase("OTP Matched")){
            model.addAttribute("email",email);
            return "user/setNewPassword";
        }
        model.addAttribute("failure", result);
        model.addAttribute("otpSent", true);
        model.addAttribute("email", email);
        return "user/resetPassword";
    }

    @PostMapping("setNewPassword")
    public String setNewPassword(@RequestParam String email, @RequestParam String newPassword,
            @RequestParam String confirmPassword, Model model) {

        String result = loginService.resetNewPassword(email, newPassword, confirmPassword);

        System.out.println("Result of new password: " + result);

        if (result.equalsIgnoreCase("Password Updated")) {
            model.addAttribute("success", "Password updated successfully. Please login.");
            return "login";
        }
        model.addAttribute("email", email);

        if (result.startsWith("Password must")) {
            model.addAttribute("passwordError", result);
        } else if (result.equalsIgnoreCase("Passwords do not match.")) {
            model.addAttribute("confirmPasswordError", result);
        } else {
            model.addAttribute("failure", result);
        }

        return "user/setNewPassword";
    }
}
