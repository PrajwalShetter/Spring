package com.xworkz.common.repository;

import com.xworkz.common.entity.UserEntity;

public interface UserRepo {

    boolean saveUser(UserEntity user);
    UserEntity findByEmail(String email);
    UserEntity findByPhoneNumber(Long phone);
    boolean updateUser(UserEntity userEntity);
    UserEntity findById(int id);
}
