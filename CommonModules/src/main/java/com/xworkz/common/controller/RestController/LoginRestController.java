package com.xworkz.common.controller.RestController;

import com.xworkz.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping("/")
@RestController
public class LoginRestController {

    @Autowired
    private LoginService loginService;

    @GetMapping("checkPassword")
    public String passwordMatch(@RequestParam String email, @RequestParam String password, HttpSession session) {

        System.out.println("Check password API reached");

        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return "Email and password are required";
        }

        String msg = loginService.passwordMatch(email, password);

        System.out.println("Password check result from restController: " + msg);

        if(msg.equalsIgnoreCase("Account is Blocked. please reset the password")){
            session.setAttribute("email", email);
            return "Account_Blocked";
        }
        return msg;
    }
}
