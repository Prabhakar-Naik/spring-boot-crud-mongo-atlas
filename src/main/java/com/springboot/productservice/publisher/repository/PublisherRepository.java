package com.springboot.productservice.publisher.repository;

import com.springboot.productservice.publisher.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,String> {
}
