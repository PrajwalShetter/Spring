package com.xworkz.jobportal.service;

import com.xworkz.jobportal.dto.ApplicantDto;

import java.util.List;

public interface ApplicantService {

    boolean saveApplicant(ApplicantDto applicantDto);
    List<ApplicantDto> getAllApplicant();
    ApplicantDto getApplicantById(int id);
}
