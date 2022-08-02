package com.tanibourne.springleveltwo.service;

import com.tanibourne.springleveltwo.domain.Product;
import com.tanibourne.springleveltwo.dto.ProductMypriceRequestDto;
import com.tanibourne.springleveltwo.dto.ProductRequestDto;
import com.tanibourne.springleveltwo.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDto requestDto, Long userId)  {
// 요청받은 DTO로 DB에 저장할 객체를 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        if (requestDto.getMyprice() <= 0) {
            throw new RuntimeException("최저가 0원 이하 에러");
        }
        Product product = productRepository.findById(id).orElseThrow(

                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        int myprice = requestDto.getMyprice();
        product.setMyprice(myprice);
        productRepository.save(product);

        return product;
    }

    public List<Product> getProducts(Long userId)  {

        return productRepository.findAllByUserId(userId);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}
