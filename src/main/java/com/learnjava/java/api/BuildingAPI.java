package com.learnjava.java.api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnjava.java.Beans.BuildingDTO;

@Controller
public class BuildingAPI {

    @RequestMapping(value = "/api/building/", method = RequestMethod.GET)
    @ResponseBody
    public BuildingDTO getBuilding(@RequestParam(value = "name", required = false) String nameBuilding,
            @RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
            @RequestParam(value = "ward", required = false) String ward) {
        BuildingDTO result = new BuildingDTO();
        result.setName(nameBuilding);
        result.setNumberOfBasement(numberOfBasement);
        result.setWard(ward);
        return result;
        // System.out.println(nameBuilding + " " + numberOfBasement);
    }

    @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
    public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
        System.out.println("ok2");
    }
}
