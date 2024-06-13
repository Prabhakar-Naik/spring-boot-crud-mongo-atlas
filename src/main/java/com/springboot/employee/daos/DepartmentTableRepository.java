package com.springboot.employee.daos;

import com.springboot.employee.model.DepartmentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author prabhakar, @Date 13-06-2024
 */
@Repository
public interface DepartmentTableRepository extends JpaRepository<DepartmentTable,String> {
}
