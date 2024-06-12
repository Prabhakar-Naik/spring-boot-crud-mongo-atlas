package com.springboot.productservice.publisher.controller;

import com.springboot.productservice.publisher.model.Publisher;
import com.springboot.productservice.publisher.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository repository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Publisher publisher){
        this.repository.save(publisher);
        return ResponseEntity.ok("success");
    }


}
