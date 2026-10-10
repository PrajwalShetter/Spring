package com.xworkz.common.repository;

import com.xworkz.common.entity.LoginEntity;
import org.springframework.stereotype.Repository;


public interface LoginRepo {

    boolean saveLogin(LoginEntity loginEntity);
}
