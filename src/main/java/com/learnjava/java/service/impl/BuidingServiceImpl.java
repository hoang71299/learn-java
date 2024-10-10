package com.learnjava.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.java.model.BuildingDTO;
import com.learnjava.java.repository.BuildingRepository;
import com.learnjava.java.repository.entity.BuildingEntity;
import com.learnjava.java.service.BuildingService;

@Service
public class BuidingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository BuildingRepository;

    @Override
    public List<BuildingDTO> findAll(String name, Long districtId) {
        // TODO Auto-generated method stub
        List<BuildingEntity> buildingEntities = BuildingRepository.findAll(name, districtId);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO building = new BuildingDTO();
            building.setName(item.getName());
            building.setAddress(item.getStreet() + "," + item.getWard());
            building.setNumberOfBasement(item.getNumberOfBasement());
            result.add(building);
        }
        return result;
    }

}
