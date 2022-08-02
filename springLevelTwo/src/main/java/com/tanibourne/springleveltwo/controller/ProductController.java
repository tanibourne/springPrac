package com.tanibourne.springleveltwo.controller;

import com.tanibourne.springleveltwo.domain.Product;
import com.tanibourne.springleveltwo.dto.ProductMypriceRequestDto;
import com.tanibourne.springleveltwo.dto.ProductRequestDto;
import com.tanibourne.springleveltwo.security.UserDetailsImpl;
import com.tanibourne.springleveltwo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    } // 이 형태가 @RequiredArgsConstructor @Autowired는 생략 가능
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Long userId = userDetails.getUser().getId();

        return productService.createProduct(requestDto,userId);
    }
    // 신규 상품 등록


    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        Product product = productService.updateProduct(id, requestDto);
// 응답 보내기 (업데이트된 상품 id)
        return product.getId();
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        Long userId = userDetails.getUser().getId();
        return productService.getProducts(userId);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/api/admin/products")
    public List<Product> getAllProducts() {
        // 응답 보내기

        return productService.getAllProducts();
    }
}