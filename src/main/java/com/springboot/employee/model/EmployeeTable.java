package com.springboot.employee.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class EmployeeTable {

//    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 50)
    private String employeeId;
    @Column(length = 15,nullable = false,unique = true)
    private String identifier;
    @Column(length = 20,nullable = false)
    private String firstName;
    @Column(length = 20,nullable = false)
    private String lastName;
    @Column(length = 30,nullable = false,unique = true)
    private String email;
    @Column(length = 10)
    private LocalDate birthDate;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressTable address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentTable department;

    @ManyToMany
    @JoinTable(
            name = "employee_mission",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")

    )
    private List<MissionTable> missions;

}
