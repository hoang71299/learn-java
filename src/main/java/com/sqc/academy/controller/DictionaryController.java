package com.sqc.academy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DictionaryController {
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            Map.entry("hello", "xin chào"),
            Map.entry("apple", "quả táo"),
            Map.entry("banana", "quả chuối"),
            Map.entry("orange", "quả cam"),
            Map.entry("lemon", "quả chanh"),
            Map.entry("melon", "quả dưa"),
            Map.entry("watermelon", "quả dưa hấu"),
            Map.entry("blueberry", "quả việt quất")
    );

    @GetMapping("/dictionary")
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String word){


        String transolation = dictionaryMap.get(word.trim().toLowerCase());
        if(transolation != null){
            return ResponseEntity.ok(transolation);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("khong tim thay gi het");
    }


}
