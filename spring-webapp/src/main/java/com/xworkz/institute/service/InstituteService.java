package com.xworkz.institute.service;

import com.xworkz.institute.dto.InstituteDto;

import java.util.List;

public interface InstituteService {

    void saveInstitute(InstituteDto instituteDto);
    List<InstituteDto> getAllInstitute();
    InstituteDto getInstituteById(int id);
    public void  updateInstitute(InstituteDto instituteDto);
    boolean deleteInstitute(int id);
}
