package com.learnjava.java.api;

import java.util.List;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.java.customexception.FieldRequiredException;
import com.learnjava.java.model.BuildingDTO;
import com.learnjava.java.model.ErrorResonseDTO;
import com.learnjava.java.service.BuildingService;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    // @RequestMapping(value = "/api/building/", method = RequestMethod.GET)
    @GetMapping(value = "/api/building/") // cu phap ngan gon
    public List<BuildingDTO> getBuilding(@RequestParam(name = "name") String name) {
        List<BuildingDTO> result = buildingService.findAll(name);
        return result;
        // System.out.println(nameBuilding + " " + numberOfBasement);
    }

    public void valiDate(BuildingDTO buildingDTO) {
        if (buildingDTO.getName() == null || buildingDTO.getName().equals("")
                || buildingDTO.getNumberOfBasement() == null) {
            throw new FieldRequiredException("name or numberofbasement is null");
        }
    }
    // @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
    // @PostMapping(value = "/api/building/") // cu phap ngan gon
    // public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
    // System.out.println("ok2");
    // }

    @DeleteMapping(value = "/api/building/{id}/{name}")
    public void deleteBuilding(@PathVariable Integer id, @PathVariable String name,
            @RequestParam(value = "ward", required = false) String ward) {
        System.out.println("đã xóa nhà có id là " + id + " roi nhe");
    }
}
