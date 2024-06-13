package com.springboot.employee.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class AddressTable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 50)
    private String addressId;
    @Column(length = 25)
    private String streetName;
    @Column(length = 15)
    private String houseNumber;
    @Column(length = 20)
    private String landMark;
    @Column(length = 20)
    private String city;
    @Column(length = 25)
    private String state;
    @Column(length = 10)
    private String postalCode;
    @Column(length = 25)
    private String Country;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeTable employee;
}
