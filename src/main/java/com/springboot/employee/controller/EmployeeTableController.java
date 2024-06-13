package com.springboot.employee.controller;

import com.springboot.employee.service.EmployeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeTableController {

    @Autowired
    private EmployeeTableService service;
}
