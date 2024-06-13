package com.springboot.employee.service;

import com.springboot.employee.daos.DepartmentTableRepository;
import com.springboot.employee.model.DepartmentTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author prabhakar, @Date 13-06-2024
 */
@Service
public class DepartmentTableService {

    @Autowired
    private DepartmentTableRepository repository;


    public ResponseEntity<?> createDepartment(DepartmentTable department) {
        this.repository.save(department);
        return ResponseEntity.ok("success: "+department.getDepartmentId());
    }
}
