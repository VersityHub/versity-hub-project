package com.java.tech.versityHub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Data
@NoArgsConstructor
public class UserEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(nullable = false)
    private String FirstName;
    private String MiddleName;
    @Column(nullable = false)
    private String LastName;
    @Column(nullable = false)
    private String Email;
    @Column(nullable = false)
    private int PhoneNumber;
    private String Gender;
    @Column(nullable = false)
    private String Country;
    @Column(nullable = false)
    private String State;
    @Column(nullable = false)
    private String University;
    @Column(nullable = false)
    private String UniversityId;
    @Column(nullable = false)
    private String DateOfBirth;
    @Column(nullable = false)
    private String Password;
}
