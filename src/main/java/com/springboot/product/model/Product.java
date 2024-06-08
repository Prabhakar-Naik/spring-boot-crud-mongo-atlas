package com.springboot.product.model;

public record Product(Long id, String name,double price) {
}

// this is record wise we don't want to take a database access