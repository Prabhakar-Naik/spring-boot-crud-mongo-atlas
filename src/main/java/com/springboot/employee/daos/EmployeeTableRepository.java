package com.springboot.employee.daos;

import com.springboot.employee.model.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prabhakar, @Date 13-06-2024
 */
public interface EmployeeTableRepository extends JpaRepository<EmployeeTable,String> {

}
