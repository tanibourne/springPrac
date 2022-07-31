package com.tanibourne.springleveltwo.controller;

import com.tanibourne.springleveltwo.domain.Product;
import com.tanibourne.springleveltwo.dto.ProductMypriceRequestDto;
import com.tanibourne.springleveltwo.dto.ProductRequestDto;
import com.tanibourne.springleveltwo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {

    private final ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {

        return productService.createProduct(requestDto);
    }
    // 신규 상품 등록


    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productService.updateProduct(id, requestDto);
// 응답 보내기 (업데이트된 상품 id)
        return product.getId();
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {
        // 응답 보내기
        return productService.getProducts();
    }
}