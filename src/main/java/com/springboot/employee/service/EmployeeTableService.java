package com.springboot.employee.service;

import com.springboot.employee.daos.EmployeeTableRepository;
import com.springboot.employee.model.EmployeeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTableService {

    @Autowired
    private EmployeeTableRepository repository;


    public ResponseEntity<?> createEmployee(EmployeeTable employee) {
        return ResponseEntity.ok(this.repository.save(employee));
    }
}
