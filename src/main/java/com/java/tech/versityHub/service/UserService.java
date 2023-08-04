package com.java.tech.versityHub.service;

import com.java.tech.versityHub.dto.UserDto;
import com.java.tech.versityHub.entity.UserEntity;
import com.java.tech.versityHub.exception.EtAuthException;
import org.springframework.validation.annotation.Validated;

public interface UserService {

    UserDto CreateAccount(@Validated(UserEntity.CreateAccountValidation.class) UserDto userDto) throws EtAuthException;
    UserDto Login(@Validated(UserEntity.LoginValidation.class) UserDto userDto) throws EtAuthException;
}
