package com.springboot.productservice.products.controller;

import com.springboot.productservice.products.model.ProductService;
import com.springboot.productservice.products.repository.ProductServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/services")
public class ProductServiceController {

    @Autowired
    private ProductServiceRepository repository;

    @GetMapping(value = "/findAll")
    public List<ProductService> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductService> getProductById(@PathVariable Long id) {
        Optional<ProductService> product = this.repository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/create")
    public ProductService createProduct(@RequestBody ProductService product) {
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductService> updateProduct(@PathVariable Long id, @RequestBody ProductService productDetails) {
        Optional<ProductService> product = repository.findById(id);
        if (product.isPresent()) {
            product.get().setName(productDetails.getName());
            // Handle updates for colors and sizes as needed
            ProductService updatedProduct = repository.save(product.get());
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
