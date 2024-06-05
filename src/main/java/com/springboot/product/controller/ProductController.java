package com.springboot.product.controller;

import com.springboot.product.model.Product;
import com.springboot.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService productService){
        this.service = productService;
    }


    @PostMapping(value = "/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return this.service.createProduct(product);
    }

    @PutMapping(value = "/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return this.service.updateProduct(product);
    }

    @PatchMapping(value = "/updatePriceToProduct")
    public ResponseEntity<?> updatePriceToProduct(@RequestParam Long id,@RequestParam double price){
        return this.service.updatePriceToProduct(id,price);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return this.service.deleteProduct(id);
    }

    @GetMapping(value = "/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        return this.service.getProduct(id);
    }

    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<?>> getAllProducts(){
        return this.service.getAllProducts();
    }

}
