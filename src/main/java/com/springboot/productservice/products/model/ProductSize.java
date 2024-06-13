//package com.springboot.productservice.products.model;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//public class ProductSize implements Serializable {
//
//    private static final long serialVersionUID =1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "color_id", nullable = false)
//    private ProductColor color;
//
//    private String size;
//
//    private int quantity;
//
//    // getters and setters
//}
