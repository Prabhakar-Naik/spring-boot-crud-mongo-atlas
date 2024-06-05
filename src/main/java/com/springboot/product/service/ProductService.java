package com.springboot.product.service;

import com.springboot.product.model.Product;
import com.springboot.product.model.Products;
import com.springboot.product.repository.ProductsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final ProductsRepository repository;

    public ProductService(ProductsRepository productsRepository){
        this.repository = productsRepository;
    }

    private AtomicLong id = new AtomicLong(0);

    public ResponseEntity<?> createProduct(Product product) {
        Products products = new Products();
        products.setId(id.incrementAndGet());
        products.setName(product.name());
        products.setPrice(product.price());
        this.repository.save(products);
        return ResponseEntity.ok("Product Created: \n"+products);
    }

    public ResponseEntity<?> updateProduct(Product product) {

        Optional<Products> optional = this.repository.findById(product.id());
        if (optional.isPresent()) {
            optional.get().setName(product.name());
            optional.get().setPrice(product.price());
            this.repository.save(optional.get());
            return ResponseEntity.ok().body("Product Updated: \n"+optional.get());
        }else
            return ResponseEntity.badRequest().body("Product Id Not Found");
    }

    public ResponseEntity<?> updatePriceToProduct(Long id, double price) {
        Optional<Products> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            optional.get().setPrice(price);
            this.repository.save(optional.get());
            return ResponseEntity.ok().body("Product Price Updated: \n"+optional.get());
        }else
            return ResponseEntity.badRequest().body("Product Id Not Found");
    }

    public ResponseEntity<?> deleteProduct(Long id) {
        Optional<Products> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            this.repository.delete(optional.get());
            return ResponseEntity.ok().body("Product Deleted: ");
        }else
            return ResponseEntity.badRequest().body("Product Id Not Found");
    }

    public ResponseEntity<?> getProduct(Long id) {
        Optional<Products> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }else
            return ResponseEntity.badRequest().body("Product Id Not Found");
    }

    public ResponseEntity<List<?>> getAllProducts() {
        List<Products> products = (List<Products>) this.repository.findAll();
        if (!products.isEmpty())
            return ResponseEntity.ok(products);
        else
            return ResponseEntity.accepted().body(Collections.singletonList("products are empty."));
    }
}
