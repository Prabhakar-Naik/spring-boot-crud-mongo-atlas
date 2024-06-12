package com.springboot.productservice.products.repository;

import com.springboot.productservice.products.model.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
}
