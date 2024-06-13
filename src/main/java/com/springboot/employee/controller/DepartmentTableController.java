package com.springboot.employee.controller;

import com.springboot.employee.model.DepartmentTable;
import com.springboot.employee.service.DepartmentTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prabhakar, @Date 13-06-2024
 */
@RestController
@RequestMapping(value = "/departments")
public class DepartmentTableController {

    @Autowired
    private DepartmentTableService service;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody DepartmentTable department){
        return this.service.createDepartment(department);
    }


}
