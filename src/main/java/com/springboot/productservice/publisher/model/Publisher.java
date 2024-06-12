package com.springboot.productservice.publisher.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Publisher {

    @Id
    @Column(length = 47)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 20)
    private String name;

}
