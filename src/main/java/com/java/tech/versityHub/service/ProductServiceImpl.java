package com.java.tech.versityHub.service;

import com.java.tech.versityHub.Repository.ProductRepository;
import com.java.tech.versityHub.converter.ProductConverter;
import com.java.tech.versityHub.dto.ProductDto;
import com.java.tech.versityHub.entity.ProductEntity;
import com.java.tech.versityHub.exception.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDto uploadProduct(ProductDto productDto) throws EtAuthException {

        ProductEntity pe = productConverter.convertDtoToEntity(productDto);
        pe = productRepository.save(pe);
        productDto = productConverter.convertEntityToDto(pe);
        return productDto;
    }

    @Override
    public List<ProductDto> myProducts() {
        List<ProductEntity> productlist =(List<ProductEntity>)productRepository.findAll();
        List<ProductDto> listofproduct = new ArrayList<>();

        for (ProductEntity pe: productlist){
            ProductDto dto = productConverter.convertEntityToDto(pe);
            listofproduct.add(dto);
        }
        return listofproduct;
    }

    @Override
    public List<ProductDto> SearchProductByTitle(String title) throws EtAuthException {
        List<ProductEntity> productlist = (List<ProductEntity>) productRepository.findByTitleContainingIgnoreCase(title);
        List<ProductDto> listofproduct = new ArrayList<>();

        for (ProductEntity pe: productlist){
            ProductDto dto = productConverter.convertEntityToDto(pe);
            listofproduct.add(dto);
        }
        return listofproduct;
    }

    @Override
    public List<ProductDto> SearchProductByPrice(Double minPrice, Double maxPrice) throws EtAuthException {
        List<ProductEntity> productlist = (List<ProductEntity>) productRepository.findByPriceBetween(minPrice, maxPrice);
        List<ProductDto> listofproduct = new ArrayList<>();

        for (ProductEntity pe: productlist){
            ProductDto dto = productConverter.convertEntityToDto(pe);
            listofproduct.add(dto);
        }
        return listofproduct;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long productId) {
        Optional<ProductEntity> opten = productRepository.findById(productId);
        ProductDto dto = null;
        if(opten.isPresent()){

            ProductEntity pe = opten.get();//data form database
            pe.setTitle(productDto.getTitle());
            pe.setDescription(productDto.getDescription());
            pe.setPrice(productDto.getPrice());
            pe.setUnit(productDto.getUnit());
            pe.setUniversity(productDto.getUniversity());
            pe.setAddress(productDto.getAddress());
            dto = productConverter.convertEntityToDto(pe);
            productRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void DeleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
