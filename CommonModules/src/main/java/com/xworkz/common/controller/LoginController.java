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
        System.out.println(loginDto);
        if(binding.hasErrors()){
            List<ObjectError> allErrors = binding.getAllErrors();
            allErrors.stream().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }
        else{
            model.addAttribute("failure","Enter a valid data");
            return "login";
        }
        String message = loginService.saveLogin(loginDto);
        if(message.equalsIgnoreCase("Enter a valid Data") || message.equalsIgnoreCase("Login not saved in DB")){
            model.addAttribute("failure", "Login failed something went wrong");
            return "login";
        }
        else {
            model.addAttribute("success", "Login success");
            return "login";
        }
    }
}
