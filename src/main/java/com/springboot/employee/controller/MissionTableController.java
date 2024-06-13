package com.springboot.employee.controller;

import com.springboot.employee.model.MissionTable;
import com.springboot.employee.service.MissionTableService;
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
@RequestMapping(value = "/missions")
public class MissionTableController {

    @Autowired
    private MissionTableService service;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody MissionTable missionTable){
        return this.service.createMission(missionTable);
    }


}
