package com.springboot.employee.controller;

import com.springboot.employee.model.AddressTable;
import com.springboot.employee.service.AddressTableService;
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
@RequestMapping(value = "/addresses")
public class AddressTableController {

    @Autowired
    private AddressTableService service;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody AddressTable addressTable){
        return this.service.createAddress(addressTable);
    }
}
