package com.prueba.agenda.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class PropsUtility {


    public ResponseEntity<Object> generatedResponse(HttpStatus status, String messages, Object response) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", response);
        res.put("messages", messages);
        res.put("status", status.value());
        return new ResponseEntity<Object>(res, status);
    }
}
