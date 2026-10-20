package com.xworkz.common.controller;

import com.xworkz.common.dto.UserDto;
import com.xworkz.common.service.UserService;
import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.jvnet.staxex.NamespaceContextEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Binding;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private File profilePicDirectory;

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
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("home")
    public String homepage(HttpSession session, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        String email = (String)session.getAttribute("loggedInEmail");
        if(email == null){
            return "redirect:/login";
        }
        return "user/Index";
    }

    @GetMapping("profile")
    public String getProfile(HttpSession session, Model model, HttpServletResponse response) {

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        String email = (String) session.getAttribute("loggedInEmail");
        if (email == null) {
            return "redirect:/login";
        }
        UserDto userDto = userService.findByEmail(email);
        if (userDto == null) {
            session.invalidate();
            return "redirect:/login";
        }
        model.addAttribute("profile", userDto);
        return "user/profile";
    }

    @PostMapping("uploadProfilePic")
    public String uploadProfilePic(@RequestParam("profilePicFile") MultipartFile profilePicFile, HttpSession session, Model model, HttpServletResponse response) throws IOException {
        String email = (String) session.getAttribute("loggedInEmail");
        if (email == null) {
            return "redirect:/login";
        }
        if (profilePicFile == null || profilePicFile.isEmpty()) {
            model.addAttribute("picNotUpload", "Please select a picture");
            return getProfile(session, model,response);
        }
        String fileName = profilePicFile.getOriginalFilename();
        if (fileName == null || fileName.trim().isEmpty()) {
            model.addAttribute("picNotUpload", "Invalid file name");
            return getProfile(session, model, response);
        }
        File file = new File(profilePicDirectory, fileName);
        profilePicFile.transferTo(file);
        System.out.println("File saved successfully: " + file.exists());
        System.out.println("Saved at: " + file.getAbsolutePath());
        String result = userService.uploadProfilePic(email, fileName);
        if (result.equalsIgnoreCase("updated successfully")) {
            model.addAttribute("picUpload", "Uploaded successfully");
        } else {
            model.addAttribute("picNotUpload", "Unable to upload picture");
        }
        return getProfile(session, model, response);
    }


    @GetMapping("profile-picture")
    public void getFile(HttpSession session, HttpServletResponse response){
        String email =(String) session.getAttribute("loggedInEmail");

        UserDto userDto = userService.findByEmail(email);
        if(userDto == null || userDto.getProfilePic() == null){
            return;
        }

        File file = new File(profilePicDirectory,userDto.getProfilePic());

        try{
            FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fileInput);
            OutputStream outputStream = response.getOutputStream();

            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("editProfile")
    public  String editProfile(HttpSession session, Model model, HttpServletResponse response){
        response.setHeader("Cache-Control", "no_cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        String email = (String) session.getAttribute("loggedInEmail");
        if(email == null){
            return "redirect:/login";
        }
        UserDto user= userService.findByEmail(email);
        if(user == null){
            session.invalidate();
            return "redirect:/login";
        }
        model.addAttribute("user",user);
        return "user/editProfile";
    }

    @PostMapping("updateProfile")
    public String updateProfile( @RequestParam(value = "profilePicFile", required = false)
                                     MultipartFile profilePicFile,  UserDto userdto,Model model){
        if(userdto == null){
            return "redirect:/profile";
        }
        boolean save = userService.updateById(userdto);
        if(save){
            model.addAttribute("success", "updated successfully");
            return "redirect:/profile";
        }
        model.addAttribute("failure", "something went wrong");
        return "redirect:/editProfile";
    }

}
