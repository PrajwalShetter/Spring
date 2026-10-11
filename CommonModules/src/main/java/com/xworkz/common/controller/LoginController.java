package com.xworkz.common.controller;

import com.xworkz.common.dto.LoginDto;
import com.xworkz.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public String saveLogin(@Valid LoginDto loginDto, Model model, BindingResult binding){
        System.out.println("Login controller reached");
        System.out.println(loginDto);

        if (binding.hasErrors()) {
            binding.getAllErrors().forEach(error -> {
                System.out.println("Validation error: "
                        + error.getDefaultMessage());
            });

            model.addAttribute("failure", "Enter valid data");
            return "login";
        }

        System.out.println("Before calling login service");

        String message = loginService.saveLogin(loginDto);

        System.out.println("After calling login service");
        System.out.println("Message: " + message);
        if (message.equalsIgnoreCase("Login saved successfully into DB")) {
            model.addAttribute("success", "Login successful");
        } else {
            model.addAttribute("failure", message);
        }
        return "login";

    }
}
