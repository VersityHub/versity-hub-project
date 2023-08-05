package com.java.tech.versityHub.converter;

import com.java.tech.versityHub.dto.ProductDto;
import com.java.tech.versityHub.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {


    public ProductEntity convertDtoToEntity(ProductDto productDto){

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setTitle(productDto.getTitle());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setUnit(productDto.getUnit());
        productEntity.setUniversity(productDto.getUniversity());
        productEntity.setAddress(productDto.getAddress());
        return productEntity;
    }

    public ProductDto convertEntityToDto(ProductEntity productEntity){

        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setTitle(productEntity.getTitle());
        productDto.setDescription(productEntity.getDescription());
        productDto.setPrice(productEntity.getPrice());
        productDto.setUnit(productEntity.getUnit());
        productDto.setUniversity(productEntity.getUniversity());
        productDto.setAddress(productEntity.getAddress());
        return productDto;
    }
}
