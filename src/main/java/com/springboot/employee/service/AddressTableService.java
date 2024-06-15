package com.springboot.employee.service;

import com.springboot.employee.daos.AddressTableRepository;
import com.springboot.employee.model.AddressTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author prabhakar, @Date 13-06-2024
 */
@Service
public class AddressTableService {

    @Autowired
    private AddressTableRepository repository;


    public ResponseEntity<?> createAddress(AddressTable addressTable) {
        return ResponseEntity.ok(this.repository.save(addressTable));
    }
}
