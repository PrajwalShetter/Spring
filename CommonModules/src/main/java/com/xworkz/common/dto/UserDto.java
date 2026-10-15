package com.xworkz.common.dto;

import com.xworkz.common.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Integer id;

    @NotNull(message = "Name should not be null")
    @NotEmpty(message = "Name should not be Empty")
    @NotBlank(message = "Name should not be Blank")
    @Size(min = 3,max = 20, message = "Name should be at least 3 char and max 20 char")
    private String name;

    @NotNull(message = "gender should not be null")
    private Gender gender;

    @NotNull(message = "Phone number should not be null")
    @Min(value = 6000000000L,
            message = "Contact number should contain at least 10 digits")
    @Max(value = 9999999999L,
            message = "Contact number should contain 10 digits")
    private Long phone;

    @AssertTrue(message = "Contact number must start with 6, 7, 8, or 9")
    public boolean isPhoneNumberValid() {

        System.out.println("Phone validation method called");
        if (phone == null) {
            return true;
        }

        String number = phone.toString();
        return number.matches("^[6-9][0-9]{9}$");
    }


    @Size(min = 8, max = 20, message = "password should at least 8 char")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$",
            message = "Password must contain at least 8 characters, 1 uppercase letter and 1 symbol"
    )
    private String password;

    @Email
    @NotNull(message = "email should not be null")
    @NotBlank(message = "email should not be Blank")
    @NotEmpty(message = "email should not be Empty")
    private String email;

    @NotNull(message = "confirmPassword should not be null")
    @NotBlank(message = "ConfirmPassword should not be Blank")
    @NotEmpty(message = "ConfirmPassword should not be Empty")
    private String confirmPassword;

    private Boolean status;
    private Integer count;

    private String otp;
}
