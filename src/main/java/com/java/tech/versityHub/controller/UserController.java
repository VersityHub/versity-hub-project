package com.java.tech.versityHub.controller;

import com.java.tech.versityHub.dto.UserDto;
import com.java.tech.versityHub.entity.UserEntity;
import com.java.tech.versityHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> CreateAccount(@Validated(UserEntity.CreateAccountValidation.class)@RequestBody UserDto userDto){
        userDto= userService.CreateAccount(userDto);
        return new ResponseEntity<String>("Account created. You can now Login", HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@Validated({UserEntity.LoginValidation.class})@RequestBody UserDto userDto){
        userDto = userService.Login(userDto);
        return new ResponseEntity<String>("Login successfully", HttpStatus.ACCEPTED);

    }
}
