package com.xworkz.institute.repo;

import com.xworkz.institute.entity.InstituteEntity;

import java.util.List;

public interface InstituteRepo {

    void saveInstitute(InstituteEntity institute);
    List<InstituteEntity> getAllInstitutes();
    InstituteEntity getInstituteById(int id);
    void updateInstitute(InstituteEntity institute);
    boolean deleteInstitute(int id);
}
