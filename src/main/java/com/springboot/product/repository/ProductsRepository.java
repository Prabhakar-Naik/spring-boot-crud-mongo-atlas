package com.springboot.product.repository;

import com.springboot.product.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products,Long> {
}
// or
//public interface ProductsRepository extends JpaRepository<Products,Long> {
//}