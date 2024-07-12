package com.springboot.employee.service;

import com.springboot.employee.daos.AddressTableRepository;
import com.springboot.employee.daos.DepartmentTableRepository;
import com.springboot.employee.daos.EmployeeTableRepository;
import com.springboot.employee.daos.MissionTableRepository;
import com.springboot.employee.model.AddressTable;
import com.springboot.employee.model.DepartmentTable;
import com.springboot.employee.model.EmployeeTable;
import com.springboot.employee.model.MissionTable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeTableService {

    private final EmployeeTableRepository repository;

    private final AddressTableRepository addressRepository;

    private final MissionTableRepository missionRepository;
    private final DepartmentTableRepository departmentRepository;


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
        employee.setAddress(address);
        AddressTable addressTable = this.addressRepository.save(address);
        System.out.println(addressTable.getAddressId());
        return ResponseEntity.ok(this.repository.save(employee));
    }


    public ResponseEntity<?> createEmployee1(EmployeeTable employeeTable){
        Optional<AddressTable> optionalAddressTable = this.addressRepository.findById(employeeTable.getAddress().getAddressId());
        List<MissionTable> optionalMissionTable = this.missionRepository.findAllById(employeeTable.getMissions().stream().map(MissionTable::getMissionId).collect(Collectors.toList()));
        Optional<DepartmentTable> optionalDepartmentTable = this.departmentRepository.findById(employeeTable.getDepartment().getDepartmentId());

        if (optionalAddressTable.isPresent() && optionalDepartmentTable.isPresent()){
            if (!optionalMissionTable.isEmpty()){
                optionalAddressTable.get().setEmployee(employeeTable);
                employeeTable.setAddress(optionalAddressTable.get());

                employeeTable.setDepartment(optionalDepartmentTable.get());
                employeeTable.setMissions(optionalMissionTable);
                this.repository.save(employeeTable);
                return ResponseEntity.ok().body("employee created: "+employeeTable.getEmployeeId());
            }else
                return ResponseEntity.badRequest().body("Mission not Found.");
        }else {
            return ResponseEntity.badRequest().body("Address or Department Not Found.");
        }
    }


}
