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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Binding;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public String saveUser(@Valid UserDto userDto, BindingResult binding, Model model) {
        System.out.println(userDto);
        // Bean Validation errors
        if (binding.hasErrors()) {
            List<ObjectError> allErrors = binding.getAllErrors();
            allErrors.stream().forEach(objectError -> {
                System.out.println(objectError.getDefaultMessage());
            });
            model.addAttribute("failure", "Enter valid data");
            return "registration";
        }

        // Service validation
        String message = userService.saveUser(userDto);
        if (message.equalsIgnoreCase("User registration failed")
                || message.equalsIgnoreCase("Email already exists")
                || message.equalsIgnoreCase("Phone number already exists")) {

            model.addAttribute("failure", message);
            return "registration";

        } else {
            model.addAttribute("success", message);
            return "login";
        }

    }

    @GetMapping("logout")
    public String logout(){
        return "login";
    }

    @GetMapping("home")
    public String homepage(){
        return "user/Index";
    }

    @GetMapping("profile")
    public String viewProfile( Model model,HttpSession session){
        String email = (String)session.getAttribute("loggedInEmail");
        if(email==null){
            return "login";
        }
        UserDto userDto = userService.findByEmail(email);
        System.out.println(userDto);
        model.addAttribute("profile", userDto);
        return "user/profile";
    }





}
