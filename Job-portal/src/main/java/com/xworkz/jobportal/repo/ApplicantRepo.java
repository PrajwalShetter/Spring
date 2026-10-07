package com.xworkz.jobportal.repo;

import com.xworkz.jobportal.entity.ApplicantEntity;

import java.util.List;

public interface ApplicantRepo {

    boolean saveApplicant(ApplicantEntity applicantEntity);
    List<ApplicantEntity> getAll();
    ApplicantEntity getApplicantById(int id);
}
