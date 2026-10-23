package com.xworkz.common.service;

import com.xworkz.common.dto.UserDto;
import com.xworkz.common.entity.UserEntity;

public interface UserService {
    String saveUser(UserDto userDto);
    UserDto findByEmail(String email);
    UserDto findByPhoneNumber(Long phone);
    boolean updateUser(UserDto userDto);
    String uploadProfilePic(String email,String fileName);
    boolean updateById(UserDto userDto);
}
