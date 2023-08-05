package com.java.tech.versityHub.controller;

import com.java.tech.versityHub.dto.ProductDto;
import com.java.tech.versityHub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/upload")
    public ResponseEntity<ProductDto> UploadProduct(@RequestBody ProductDto productDto){
        productDto = productService.uploadProduct(productDto);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
    }
    @GetMapping("/myproducts")
    public ResponseEntity<List<ProductDto>> MyProducts(){
        List<ProductDto> productList = productService.myProducts();
        ResponseEntity<List<ProductDto>> responseEntity = new ResponseEntity<>(productList, HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long productId){
        productDto = productService.updateProduct(productDto, productId);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
         productService.DeleteProduct(productId);
         return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam(required = false) String title,
                                                           @RequestParam(required = false) Double minPrice,
                                                           @RequestParam(required = false) Double maxPrice) {

        List<ProductDto> searchResults;
        if(title != null){
            searchResults = productService.SearchProductByTitle(title);
        }else if(minPrice != null && maxPrice != null){
            searchResults= productService.SearchProductByPrice(minPrice, maxPrice);
        }else {
            return ResponseEntity.badRequest().build();
        }

        if (searchResults.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            ResponseEntity<List<ProductDto>> responseEntity = new ResponseEntity<>(searchResults, HttpStatus.OK);
            return responseEntity;
        }
    }
}
