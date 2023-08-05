package com.java.tech.versityHub.service;

import com.java.tech.versityHub.dto.ProductDto;
import com.java.tech.versityHub.exception.EtAuthException;

import java.util.List;

public interface ProductService {

    ProductDto uploadProduct(ProductDto productDto) throws EtAuthException;
    List<ProductDto> myProducts();
    List<ProductDto> SearchProductByTitle(String title) throws EtAuthException;
    List<ProductDto> SearchProductByPrice(Double minPrice, Double maxPrice) throws EtAuthException;
    ProductDto updateProduct(ProductDto productDto, Long productId);
    void DeleteProduct(Long productId);
}
