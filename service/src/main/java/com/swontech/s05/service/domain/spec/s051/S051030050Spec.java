package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051030050Spec {

    ResponseEntity<?> updateSw(Map<String, Object> map) throws Exception;
    ResponseEntity<?> warning(String message) throws Exception;

}
