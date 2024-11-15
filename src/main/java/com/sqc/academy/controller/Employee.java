package com.sqc.academy.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String name;
    private LocalDate dob;
    private Gender gender;
    private Double salary;
    private String phone;
}
