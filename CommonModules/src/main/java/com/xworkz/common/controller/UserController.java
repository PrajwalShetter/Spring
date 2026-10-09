package com.xworkz.common.controller;

import com.xworkz.common.dto.UserDto;
import com.xworkz.common.service.UserService;
import org.jvnet.staxex.NamespaceContextEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Binding;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("signup")
    public String getSignUp(){
        return "registration";
    }

    @PostMapping("register")
    public String saveUser(@Valid UserDto userDto, BindingResult binding, Model model) {
        System.out.println(userDto);
        // Bean Validation errors
        if (binding.hasErrors()) {
            List<ObjectError> allErrors = binding.getAllErrors();
            allErrors.stream().forEach(objectError -> {
                System.out.println(objectError.getDefaultMessage());
            });
            model.addAttribute("failure", "Enter a valid data");
            return "registration";
        }
        // Service validation
        String message = userService.saveUser(userDto);
        if (message.equalsIgnoreCase("Enter a valid data") || message.equalsIgnoreCase("User Not Registered")) {
            model.addAttribute("failure", message);
            return "registration";
        } else {
            model.addAttribute("success", message);
            return "registration";
        }
    }

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }




}
