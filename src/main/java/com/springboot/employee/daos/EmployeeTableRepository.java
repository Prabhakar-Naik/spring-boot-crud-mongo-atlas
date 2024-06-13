package com.springboot.employee.daos;

import com.springboot.employee.model.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTableRepository extends JpaRepository<EmployeeTable, String> {
}
