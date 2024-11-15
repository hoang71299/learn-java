package com.sqc.academy.controller;


import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.dto.JsonResponse;
import com.sqc.academy.exception.ApiException;
import com.sqc.academy.exception.AppException;
import com.sqc.academy.exception.ErrorCode;
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
    public ResponseEntity<?> getAll(){
        return JsonResponse.ok(employees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") UUID id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return JsonResponse.ok(employee);
            }
        }

        throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee){
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return JsonResponse.created(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        for (Employee employee : employees){
            if(employee.getId().equals(id)){
                employees.remove(employee);
                return JsonResponse.noContent();
            }
        }
       throw  new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") UUID id, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee existingEmployee = employees.get(i);
            if (existingEmployee.getId().equals(id)) {
                updatedEmployee.setId(id); // giữ lại ID cũ
                employees.set(i, updatedEmployee); // cập nhật thông tin
                return JsonResponse.ok(updatedEmployee);
            }
        }

        throw  new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }
}
