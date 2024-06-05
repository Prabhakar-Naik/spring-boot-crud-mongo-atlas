package com.springboot.product.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 5)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 6)
    private double price;
}
