package com.tanibourne.week04.controller;

import com.tanibourne.week04.Dto.ProductMypriceRequestDto;
import com.tanibourne.week04.Dto.ProductRequestDto;
import com.tanibourne.week04.models.Product;
import com.tanibourne.week04.repostitory.ProductRepository;
import com.tanibourne.week04.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> readProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product creatProduct(@RequestBody ProductRequestDto requestDto){

        Product product = new Product(requestDto);

        productRepository.save(product);

        return product;


    }
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){

        return productService.update(id, requestDto);
    }




}
