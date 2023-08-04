package com.java.tech.versityHub.service;

import com.java.tech.versityHub.Repository.UserRepository;
import com.java.tech.versityHub.converter.UserConverter;
import com.java.tech.versityHub.dto.UserDto;
import com.java.tech.versityHub.entity.UserEntity;
import com.java.tech.versityHub.exception.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto CreateAccount(@Validated(UserEntity.CreateAccountValidation.class) UserDto userDto) throws EtAuthException {

        UserEntity userEntity = userConverter.convertDtoToEntity(userDto);
        Integer count = userRepository.getCountByEmail(userEntity.getEmail());
        if (count != null && count > 0) {
            throw new EtAuthException("Email already Exist");
            }
        userEntity = userRepository.save(userEntity);
        userDto = userConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto Login(@Validated(UserEntity.LoginValidation.class) UserDto userDto) throws EtAuthException {
        UserEntity userEntity = userConverter.convertDtoToEntity(userDto);
        userEntity = userRepository.findByEmailAndPassword(userEntity.getEmail(), userEntity.getPassword());

        if (userEntity == null || !userEntity.getPassword().equals(userDto.getPassword())){
            throw new EtAuthException("Invalid Email or Password");
        }
        userDto = userConverter.convertEntityToDto(userEntity);
        return userDto;
    }

}
