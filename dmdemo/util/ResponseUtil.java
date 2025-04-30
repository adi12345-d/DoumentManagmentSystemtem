package com.document.dmdemo.util;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ResponseUtil {
//
//    public static ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, Object data) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", status.value());
//        response.put("message", message);
//        response.put("data", data);
//        return new ResponseEntity<>(response, status);
//    }
//
//    public static ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String errorMessage) {
//        return buildResponse(status, errorMessage, null);
//    }
//}

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("message", message);
        response.put("data", data);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String errorMessage) {
        return buildResponse(status, errorMessage, null);
    }
}