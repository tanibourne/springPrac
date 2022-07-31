package com.tanibourne.springleveltwo.service;

import com.tanibourne.springleveltwo.domain.Product;
import com.tanibourne.springleveltwo.dto.ProductMypriceRequestDto;
import com.tanibourne.springleveltwo.dto.ProductRequestDto;
import com.tanibourne.springleveltwo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.List;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
// 요청받은 DTO로 DB에 저장할 객체를 만들기
        Product product = new Product(requestDto);
        productRepository.createProduct(product);
        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
       if (requestDto.getMyprice() <= 0){
           throw new RuntimeException("최저가 0원 이하 에러");
       }
        Product product = productRepository.getProduct(id);

        if (product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }


        productRepository.updateMyprice(id,requestDto.getMyprice());


        return product;
    }
    public List<Product> getProducts() throws SQLException {

        return productRepository.getProducts();
    }

}
