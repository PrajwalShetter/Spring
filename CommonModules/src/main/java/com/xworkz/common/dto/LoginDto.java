package com.xworkz.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginDto {

    private int id;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email can not be blank")
    @Email
    private String email;

    @Size(min = 8, max = 20, message = "password should at least 8 char")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[A-Za-z0-9]).{8,}$",message = "password must contain at least 8 char,1 uppercase and 1 symbol")
    private String password;

    @NotNull(message = "Local date can not be null")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateAndTime;

}
