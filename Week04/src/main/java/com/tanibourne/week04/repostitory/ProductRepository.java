package com.tanibourne.week04.repostitory;


import com.tanibourne.week04.models.Product;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//생성 조회 삭제를 담당
public interface ProductRepository extends JpaRepository<Product , Long> {


}
