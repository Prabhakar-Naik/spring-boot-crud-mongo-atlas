package com.springboot.productservice.customer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Customer {

    @Id
    @Column(length = 47)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

}
