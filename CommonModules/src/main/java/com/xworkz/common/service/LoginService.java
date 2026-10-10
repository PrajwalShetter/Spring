package com.xworkz.common.service;

import com.xworkz.common.dto.LoginDto;
import com.xworkz.common.entity.LoginEntity;

public interface LoginService {

     String saveLogin(LoginDto loginDto);
}
