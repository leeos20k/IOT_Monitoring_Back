package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051010040Spec {

    ResponseEntity<?> retrieveUser(Map<String, Object> map);
    ResponseEntity<?> retrieveUserDetail(Map<String, Object> map);
    ResponseEntity<?> insertUser(Map<String, Object> map);
    ResponseEntity<?> updateUser(Map<String, Object> map);
}
