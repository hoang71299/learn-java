package com.sqc.academy.dto;

import lombok.Builder;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonResponse {

    public static  <T>ResponseEntity<ApiResponse<T>> ok(T t){
        return ResponseEntity.ok(ApiResponse.<T>builder().data(t).build());
    }
    public static  <T>ResponseEntity<ApiResponse<T>> created(T t){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<T>builder().data(t).build());
    }
    public static  ResponseEntity<ApiResponse<Void>> noContent(){
        return ResponseEntity.notFound().build();
    }
}
