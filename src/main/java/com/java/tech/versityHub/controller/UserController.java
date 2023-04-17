package com.java.tech.versityHub.controller;

import com.java.tech.versityHub.dto.UserDto;
import com.java.tech.versityHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDto> CreateAccount(@RequestBody UserDto userDto){
        userDto= userService.CreateAccount(userDto);
        ResponseEntity<UserDto> responseEntity= new ResponseEntity<>(userDto, HttpStatus.CREATED);
        return responseEntity;
    }
}
