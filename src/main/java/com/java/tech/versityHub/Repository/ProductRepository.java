package com.java.tech.versityHub.Repository;

import com.java.tech.versityHub.entity.ProductEntity;
import com.java.tech.versityHub.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);
    List<ProductEntity> findByPriceBetween(Double minPrice, Double maxPrice);
}
