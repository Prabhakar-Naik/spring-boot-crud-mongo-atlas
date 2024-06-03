package com.springboot.product.service;

import com.springboot.product.repository.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductsRepository repository;

    public ProductService(ProductsRepository productsRepository){
        this.repository = productsRepository;
    }


}
