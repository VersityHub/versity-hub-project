package com.java.tech.versityHub.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "USER_TABLE")
@Setter
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long Id;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    private String firstName;
    private String middleName;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    private String lastName;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    @Email(message = "Invalid Emial format")
    private String email;
    @NotNull(groups = {LoginValidation.class, CreateAccountValidation.class}, message = "required")
    @NotEmpty(groups = {LoginValidation.class, CreateAccountValidation.class}, message = "field cannot be empty")
    @Pattern(regexp = "\\+234\\d{10}", message = "Invalid Phone number ")
    private String phoneNumber;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    @Pattern(regexp = "^(male|female)$", message = "Invalid gender")
    private String gender;
    private String country;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    private String state;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    private String university;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    private String universityId;
    @NotNull(groups = CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = CreateAccountValidation.class, message = "field cannot be empty")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "wrong DOB format: eg 31-07-2023")
    private String dateOfBirth;
    @NotNull(groups = {LoginValidation.class, CreateAccountValidation.class}, message = "required")
    @NotEmpty(groups = {LoginValidation.class, CreateAccountValidation.class}, message = "field cannot be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,15}$",
            message = "Password requires min of 8 to max or 15 characters with at least one digit & uppercase letter")
    private String password;

    public interface CreateAccountValidation{}
    public interface LoginValidation{}
}
