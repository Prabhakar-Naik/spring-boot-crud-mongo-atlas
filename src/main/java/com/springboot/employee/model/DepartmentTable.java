package com.springboot.employee.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class DepartmentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 50)
    private String departmentId;
    @Column(length = 30)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<EmployeeTable> employees;
}
