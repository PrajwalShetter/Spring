package com.xworkz.jobportal.dto;

import com.xworkz.jobportal.Constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDto {

    private int id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private Gender gender;
    private String email;
    private long mobileNumber;
    private String alternateMobileNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String highestQualification;
    private String specialization;
    private String university;
    private int graduationYear;
    private double cgpa;
    private String experienceLevel;
    private int yearsOfExperience;
    private String currentCompany;
    private String currentJobTitle;
    private String skills;
    private MultipartFile resume;
    private String linkedInProfile;
    private String githubProfile;
    private String portfolioUrl;
    private String preferredJobRole;
    private String preferredLocation;
    private String employmentType;
    private double expectedSalary;
    private String noticePeriod;
    private String username;
    private String password;
    private String confirmPassword;
}
