package com.sqc.academy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class HelloController {
    @RequestMapping("/greeting")
    public  String hello (@RequestParam(defaultValue = "Hello!!!") String name){
        return " Hello {"+name +"}!!!";
    }

    @RequestMapping("/dictionary")
    public  String Dictionary  (@RequestParam(defaultValue = "Hello!!!") Map<String, String> name){

        return " Hello {"+name +"}!!!";
    }

}
