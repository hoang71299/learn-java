package com.sqc.academy.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401, "Student is not exists!", HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXIST(40401, "Student is not exists!", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_EXIST(40403, "Employee is not exists!", HttpStatus.NOT_FOUND);

    Integer code;
    String message;
    HttpStatus status;
}