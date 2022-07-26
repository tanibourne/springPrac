package com.tanibourne.week04.service;

import com.tanibourne.week04.Dto.ProductMypriceRequestDto;
import com.tanibourne.week04.models.Product;
import com.tanibourne.week04.repostitory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        product.update(requestDto);

        return id;
    }
}
