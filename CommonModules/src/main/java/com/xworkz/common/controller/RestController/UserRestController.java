package com.xworkz.common.controller.RestController;

import com.xworkz.common.dto.UserDto;
import com.xworkz.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("checkContactNumber")
    public String checkContactNumberIsExistOrNot(@RequestParam Long phone){
        if (!String.valueOf(phone).matches("^[6-9][0-9]{9}$")) {
            return "Enter a valid Indian 10 digit mobile number";
        }
        UserDto userDto = userService.findByPhoneNumber(phone);
        if(userDto != null){
            return "The Number is Exist";
        }
        return "The Number is accepted";
    }

    @GetMapping("checkEmail")
    public String checkEmailIsExistOrNot(@RequestParam String email){
        UserDto userDto = userService.findByEmail(email);
        if(userDto != null){
            return "The Email is Exist";
        }
        return "The Email is accepted";
    }

}
