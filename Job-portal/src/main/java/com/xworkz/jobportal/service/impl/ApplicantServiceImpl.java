package com.xworkz.jobportal.service.impl;

import com.xworkz.jobportal.dto.ApplicantDto;
import com.xworkz.jobportal.entity.ApplicantEntity;
import com.xworkz.jobportal.repo.ApplicantRepo;
import com.xworkz.jobportal.service.ApplicantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    ApplicantRepo applicantRepo;
    @Override
    public boolean saveApplicant(ApplicantDto applicantDto) {
        ApplicantEntity applicantEntity = new ApplicantEntity();
        BeanUtils.copyProperties(applicantDto, applicantEntity);
        boolean saved = applicantRepo.saveApplicant(applicantEntity);
        return saved;
    }

    @Override
    public List<ApplicantDto> getAllApplicant() {
        List<ApplicantEntity> entities = applicantRepo.getAll();
        List<ApplicantDto> dtoList = new ArrayList<>();
        for (ApplicantEntity entity : entities) {
            ApplicantDto dto = new ApplicantDto();
            BeanUtils.copyProperties(entity, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public ApplicantDto getApplicantById(int id) {
        ApplicantEntity applicantEntity = applicantRepo.getApplicantById(id);
        if (applicantEntity == null) {
            return null;
        }
        ApplicantDto applicantDto = new ApplicantDto();
        BeanUtils.copyProperties(applicantEntity, applicantDto);
        return applicantDto;
    }
}
