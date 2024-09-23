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
import com.learnjava.java.Beans.ErrorResonseDTO;
import com.learnjava.java.customexception.FieldRequiredException;

@RestController
public class BuildingAPI {
    // @RequestMapping(value = "/api/building/", method = RequestMethod.GET)
    @PostMapping(value = "/api/building/") // cu phap ngan gon
    public Object getBuilding(@RequestBody BuildingDTO building) {
        // try {
        //     System.out.println(5/0);
        //     valiDate(building);
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     ErrorResonseDTO errorResonseDTO = new ErrorResonseDTO();

        //     errorResonseDTO.setError(e.getMessage());
        //     List<String> details = new ArrayList<>();
        //     details.add("check lai xem  ");
        //     errorResonseDTO.setDetail(details);

        //     return errorResonseDTO;
        // }
        // System.out.println("hello");
        // return null; 
        System.out.println(5/0);
        return null;
        // System.out.println(nameBuilding + " " + numberOfBasement);
    }
    public void valiDate(BuildingDTO buildingDTO) {
        if(buildingDTO.getName() == null || buildingDTO.getName().equals("")||buildingDTO.getNumberOfBasement() == null){
            throw new FieldRequiredException("name or numberofbasement is null");
        }
    }
    // @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
    // @PostMapping(value = "/api/building/") // cu phap ngan gon
    // public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
    //     System.out.println("ok2");
    // }

    @DeleteMapping(value = "/api/building/{id}/{name}")
    public void deleteBuilding(@PathVariable Integer id, @PathVariable String name,
            @RequestParam(value = "ward", required = false) String ward) {
        System.out.println("đã xóa nhà có id là " + id + " roi nhe");
    }
}

