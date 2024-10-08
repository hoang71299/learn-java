package com.learnjava.java.controlleradvice;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;
import java.util.ArrayList;

import com.learnjava.java.customexception.FieldRequiredException;
import com.learnjava.java.model.ErrorResonseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
            ArithmeticException ex, WebRequest request) {
        ErrorResonseDTO errorResonseDTO = new ErrorResonseDTO();
        errorResonseDTO.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("làm sao số nguyen chia đuoc cho 0");
        errorResonseDTO.setDetail(details);
        return new ResponseEntity<>(errorResonseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(
            FieldRequiredException ex, WebRequest request) {
        ErrorResonseDTO errorResonseDTO = new ErrorResonseDTO();
        errorResonseDTO.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("check lại");
        errorResonseDTO.setDetail(details);
        return new ResponseEntity<>(errorResonseDTO, HttpStatus.BAD_GATEWAY);
    }
}
