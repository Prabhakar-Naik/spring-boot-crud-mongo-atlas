package com.springboot.employee.service;

import com.springboot.employee.daos.MissionTableRepository;
import com.springboot.employee.model.MissionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author prabhakar, @Date 13-06-2024
 */
@Service
public class MissionTableService {

    @Autowired
    private MissionTableRepository repository;

    public ResponseEntity<?> createMission(MissionTable missionTable) {
        this.repository.save(missionTable);
        return ResponseEntity.ok("success"+missionTable.getMissionId());
    }
}
