package com.java.tech.versityHub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private int PhoneNumber;
    private String Gender;
    private String Country;
    private String State;
    private String University;
    private String UniversityId;
    private String DateOfBirth;
}
