package com.xworkz.institute.service.impl;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;
import com.xworkz.institute.repo.InstituteRepo;
import com.xworkz.institute.service.InstituteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    InstituteRepo instituteRepo;

    @Override
    public void saveInstitute(InstituteDto instituteDto) {

        InstituteEntity instituteEntity = new InstituteEntity();

        instituteEntity.setInstituteName(instituteDto.getInstituteName());
        instituteEntity.setAddress(instituteDto.getAddress());
        instituteEntity.setLicenced(instituteDto.isLicenced());
        instituteEntity.setContactNumber(instituteDto.getContactNumber());
        instituteEntity.setEmail(instituteDto.getEmail());

        instituteRepo.saveInstitute(instituteEntity);

    }

    @Override
    public List<InstituteDto> getAllInstitute() {

        List<InstituteDto> instituteDtoList = new ArrayList<>();

        List<InstituteEntity> instituteEntityList = instituteRepo.getAllInstitutes();

        instituteEntityList.forEach(institute -> {
            if(institute !=null){
                InstituteDto instituteDto = new InstituteDto();
                BeanUtils.copyProperties(institute,instituteDto);
                instituteDtoList.add(instituteDto);
            }
        });
        return instituteDtoList;
    }

    @Override
    public InstituteDto getInstituteById(int id) {
        InstituteEntity instituteEntity = instituteRepo.getInstituteById(id);
        InstituteDto instituteDto = new InstituteDto();
        BeanUtils.copyProperties(instituteEntity,instituteDto);
        return instituteDto;
    }

    @Override
    public void updateInstitute(InstituteDto instituteDto) {
        InstituteEntity instituteEntity = new InstituteEntity();
        BeanUtils.copyProperties(instituteDto,instituteEntity);
        instituteRepo.updateInstitute(instituteEntity);
    }

    @Override
    public boolean deleteInstitute(int id) {
        return instituteRepo.deleteInstitute(id);
    }
}