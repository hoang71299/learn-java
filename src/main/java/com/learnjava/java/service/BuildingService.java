package com.learnjava.java.service;

import java.util.List;

import com.learnjava.java.model.BuildingDTO;

public interface BuildingService {
    List<BuildingDTO> findAll(String name, Long districtId);
}
