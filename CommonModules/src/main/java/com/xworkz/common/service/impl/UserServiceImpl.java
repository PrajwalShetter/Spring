package com.xworkz.common.service.impl;

import com.xworkz.common.dto.UserDto;
import com.xworkz.common.entity.UserEntity;
import com.xworkz.common.repository.UserRepo;
import com.xworkz.common.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String saveUser(UserDto userDto) {
            if (findByEmail(userDto.getEmail()) == null) {
                if (findByPhoneNumber(userDto.getPhone()) == null) {
                    if(userDto.getPassword().equals(userDto.getConfirmPassword())){
                        UserEntity user = new UserEntity();
                        BeanUtils.copyProperties(userDto, user);
                        user.setStatus(true);
                        user.setCount(0);
                        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                        boolean save = userRepo.saveUser(user);
                        if (save) {
                            return "user registered Successfully";
                        } else {
                            return "user registration failed";
                        }
                    }
                    return "Password does not Match with ConfirmPassword";

                }
                return "phone Number already exist";

            }
            return "Email already exist";
    }

    @Override
    public UserDto findByEmail(String email) {
        UserEntity userByEmail = userRepo.findByEmail(email);
        if (userByEmail != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userByEmail, userDto);
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto findByPhoneNumber(Long phone) {
        UserEntity userByPhoneNumber = userRepo.findByPhoneNumber(phone);
        if (userByPhoneNumber != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userByPhoneNumber, userDto);
            return userDto;
        }
        return null;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        return userRepo.updateUser(userEntity);
    }


    @Override
    public String uploadProfilePic(String email, String fileName) {
        UserDto user = findByEmail(email);
        if (user == null) {
            return "user not found";
        }
        user.setProfilePic(fileName);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        boolean update = userRepo.updateUser(userEntity);
        if (!update) {
            return "unable to update";
        }
        return "updated successfully";
    }


    @Override
    public boolean updateById(UserDto userDto) {

        UserEntity userEntity = userRepo.findById(userDto.getId());

        if (userEntity == null) {
            return false;
        }
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhone(userDto.getPhone());
        userEntity.setGender(userDto.getGender());
        return userRepo.updateUser(userEntity);

    }
}
