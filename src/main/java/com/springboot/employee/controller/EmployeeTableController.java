package com.springboot.employee.controller;

import com.springboot.employee.model.EmployeeTable;
import com.springboot.employee.service.EmployeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeTableController {

    @Autowired
    private EmployeeTableService service;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeTable employee){
        return this.service.createEmployee(employee);
    }
}
