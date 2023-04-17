package com.java.tech.versityHub.service;

import com.java.tech.versityHub.dto.UserDto;

public interface UserService {

    UserDto CreateAccount(UserDto userDto);
    UserDto Login(String Email, String Password);
}
