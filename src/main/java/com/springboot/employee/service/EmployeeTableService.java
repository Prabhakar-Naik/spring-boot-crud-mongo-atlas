package com.springboot.employee.service;

import com.springboot.employee.daos.AddressTableRepository;
import com.springboot.employee.daos.EmployeeTableRepository;
import com.springboot.employee.model.AddressTable;
import com.springboot.employee.model.EmployeeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTableService {

    @Autowired
    private EmployeeTableRepository repository;

    private AddressTableRepository addressRepository;


    public ResponseEntity<?> createEmployee(EmployeeTable employee) {

        AddressTable address = new AddressTable();
        address.setStreetName(employee.getAddress().getStreetName());
        address.setHouseNumber(employee.getAddress().getHouseNumber());
        address.setLandMark(employee.getAddress().getLandMark());
        address.setCity(employee.getAddress().getCity());
        address.setState(employee.getAddress().getState());
        address.setPostalCode(employee.getAddress().getPostalCode());
        address.setCountry(employee.getAddress().getCountry());
        //address.setEmployee(employee);
        this.addressRepository.save(address);
        return ResponseEntity.ok(this.repository.save(employee));
    }
}
