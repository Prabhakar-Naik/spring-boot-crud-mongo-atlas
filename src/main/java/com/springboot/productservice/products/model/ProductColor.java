//package com.springboot.productservice.products.model;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.io.Serializable;
//import java.util.List;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Data
//@Entity
//public class ProductColor implements Serializable {
//
//    private static final long serialVersionUID =1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private ProductService productService;
//
//    private String color;
//
//    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ProductSize> sizes;
//
//    // getters and setters
//}
