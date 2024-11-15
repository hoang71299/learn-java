package com.sqc.academy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculator")
    public ResponseEntity<String> calculate(
            @RequestParam(value = "firstNumber", defaultValue = "") String firstNumberStr,
            @RequestParam(value = "secondNumber", defaultValue = "") String secondNumberStr,
            @RequestParam(value = "operator", defaultValue = "") String operator) {

        if (firstNumberStr.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("First number cannot be empty.");
        } else if (secondNumberStr.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Second number cannot be empty.");
        } else if (!isDouble(firstNumberStr)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("First number must be a number.");
        } else if (!isDouble(secondNumberStr)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Second number must be a number.");
        }

        double firstNumber = Double.parseDouble(firstNumberStr);
        double secondNumber = Double.parseDouble(secondNumberStr);
        double result;

        switch (operator) {
            case "+":
                result = firstNumber  + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Second number must be different from 0.");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid operator.");
        }

        return ResponseEntity.ok("Result: " + result);
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
