package com.xworkz.jobportal.controller;

import com.xworkz.jobportal.dto.ApplicantDto;
import com.xworkz.jobportal.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;

    @PostMapping("registerJobSeeker")
    public String applicantRegistration(ApplicantDto applicantDto) {
        System.out.println(applicantDto);
//        System.out.println("Resume Name : " + resume.getOriginalFilename());
//        System.out.println("Resume Size : " + resume.getSize());
//        System.out.println("Resume Type : " + resume.getContentType());
        boolean isSaved = applicantService.saveApplicant(applicantDto);
        if (isSaved) {
            return "success";
        }
        return "error";
    }

    @GetMapping("viewAllApplicants")
    public String viewAllApplicants(Model model) {
        List<ApplicantDto> applicants = applicantService.getAllApplicant();
        System.out.println("Applicants : " + applicants);
        model.addAttribute("applicants", applicants);
        return "viewallApplicants";
    }

    @GetMapping("viewApplicant")
    public String viewApplicant(@RequestParam int id, Model model) {
        ApplicantDto applicantDto = applicantService.getApplicantById(id);
        model.addAttribute("applicant", applicantDto);
        return "viewApplicant";
    }


}
