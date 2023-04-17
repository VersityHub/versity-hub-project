package com.java.tech.versityHub.service;

import com.java.tech.versityHub.Repository.UserRepository;
import com.java.tech.versityHub.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto CreateAccount(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto Login(String Email, String Password) {
        return null;
    }
}
