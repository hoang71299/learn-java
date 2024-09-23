package com.learnjava.java.api;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learnjava.java.Beans.BuildingDTO;

@RestController
public class BuildingAPI {
    // @RequestMapping(value = "/api/building/", method = RequestMethod.GET)
    @GetMapping(value = "/api/building/") // cu phap ngan gon
    public BuildingDTO getBuilding(@RequestParam(value = "name", required = false) String nameBuilding,
            @RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
            @RequestParam(value = "ward", required = false) String ward) {
        try {
            System.out.println(5/0);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        BuildingDTO result = new BuildingDTO();
        result.setName(nameBuilding);
        result.setNumberOfBasement(numberOfBasement);
        result.setWard(ward);
        return result;
        // System.out.println(nameBuilding + " " + numberOfBasement);
    }

    // @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
    @PostMapping(value = "/api/building/") // cu phap ngan gon
    public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
        System.out.println("ok2");
    }

    @DeleteMapping(value = "/api/building/{id}/{name}")
    public void deleteBuilding(@PathVariable Integer id, @PathVariable String name,
            @RequestParam(value = "ward", required = false) String ward) {
        System.out.println("đã xóa nhà có id là " + id + " roi nhe");
    }
}

