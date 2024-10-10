package com.learnjava.java.repository;

import java.util.ArrayList;
import java.util.List;

import com.learnjava.java.repository.entity.BuildingEntity;

public interface BuildingRepository {
    List<BuildingEntity> findAll(String name, Long districtId);

    void DeleteById(long Id);

}
