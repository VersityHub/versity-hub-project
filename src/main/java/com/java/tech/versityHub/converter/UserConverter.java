package com.java.tech.versityHub.converter;

import com.java.tech.versityHub.dto.UserDto;
import com.java.tech.versityHub.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public UserEntity convertDtoToEntity(UserDto userDto){

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setMiddleName(userDto.getMiddleName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setGender(userDto.getGender());
        userEntity.setCountry(userDto.getCountry());
        userEntity.setState(userDto.getState());
        userEntity.setDateOfBirth(userDto.getDateOfBirth());
        userEntity.setPhoneNumber(userDto.getPhoneNumber());
        userEntity.setUniversity(userDto.getUniversity());
        userEntity.setUniversityId(userDto.getUniversityId());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }

    public UserDto convertEntityToDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setMiddleName(userEntity.getMiddleName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setGender(userEntity.getGender());
        userDto.setCountry(userEntity.getCountry());
        userDto.setState(userEntity.getState());
        userDto.setGender(userEntity.getGender());
        userDto.setDateOfBirth(userEntity.getDateOfBirth());
        userDto.setPhoneNumber(userEntity.getPhoneNumber());
        userDto.setUniversity(userEntity.getUniversity());
        userDto.setUniversityId(userEntity.getUniversityId());

        return userDto;
    }
}
