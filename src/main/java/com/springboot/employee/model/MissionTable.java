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
public class MissionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 50)
    private String missionId;
    @Column(length = 25)
    private String name;
    @Column(length = 10)
    private int duration;

    @ManyToMany(mappedBy = "missions",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
    })
    private List<EmployeeTable> employees;
}
