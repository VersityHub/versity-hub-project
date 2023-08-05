package com.java.tech.versityHub.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TABLE")
@Data
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long Id;
    @NotNull(groups = UserEntity.CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = UserEntity.CreateAccountValidation.class, message = "field cannot be empty")
    private String title;
    @NotNull(groups = UserEntity.CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = UserEntity.CreateAccountValidation.class, message = "field cannot be empty")
    private String description;
    @NotNull(groups = UserEntity.CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = UserEntity.CreateAccountValidation.class, message = "field cannot be empty")
    private Double price;
    private String unit;
    private String university;
    @NotNull(groups = UserEntity.CreateAccountValidation.class, message = "required")
    @NotEmpty(groups = UserEntity.CreateAccountValidation.class, message = "field cannot be empty")
    private String address;
}
