package com.learnjava.java.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learnjava.java.model.BuildingDTO;
import com.learnjava.java.repository.BuildingRepository;
import com.learnjava.java.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";

    @Override
    public List<BuildingEntity> findAll(String name) {
        String sql = "SELECT * FROM building  WHERE name like '%" + name + "%'";
        List<BuildingEntity> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                BuildingEntity building = new BuildingEntity();
                building.setName(rs.getString("name"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setNumberOfBasement(rs.getInt("numberOfBasement"));
                result.add(building);
            }
            System.out.println("Connected database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected database fail");
        }
        return result;
    }

}
