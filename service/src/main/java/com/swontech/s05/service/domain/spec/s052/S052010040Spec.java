package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052010040Spec {
    ResponseEntity<?> getMasterDetail(Map<String, Object> map);

    ResponseEntity<?> insertMaster(Map<String, Object> map);

    ResponseEntity<?> updateMaster(Map<String, Object> map);
}
