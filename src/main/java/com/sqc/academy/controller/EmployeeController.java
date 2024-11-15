package com.sqc.academy.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final List<Employee> employees =new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(),
                            "hoàng", LocalDate.of(2003,7, 7),
                            Gender.MALE,25000.00,"12345678"),
                    new Employee(UUID.randomUUID(),"trân", LocalDate.of(2001,8,1),
                            Gender.FEMALE,340000.00,"482372348")
                    )
            );
    @GetMapping()
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") UUID id){
        for (Employee employee : employees){
            if(employee.getId().equals(id)){
                return ResponseEntity.ok(employee);
            }
        }

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        for (Employee employee : employees){
            if(employee.getId().equals(id)){
                employees.remove(employee);
                return  ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable("id") UUID id, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee existingEmployee = employees.get(i);
            if (existingEmployee.getId().equals(id)) {
                updatedEmployee.setId(id); // giữ lại ID cũ
                employees.set(i, updatedEmployee); // cập nhật thông tin
                return ResponseEntity.ok(updatedEmployee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
