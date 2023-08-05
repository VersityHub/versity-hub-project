package com.java.tech.versityHub.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long Id;
    private String title;
    private String description;
    private Double price;
    private String unit;
    private String university;
    private String address;
}
