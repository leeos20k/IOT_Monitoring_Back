package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052030210Spec {
    ResponseEntity<?> getRegFixMgn(Map<String, Object> map);
    ResponseEntity<?> insertFix010(Map<String, Object> map);
    ResponseEntity<?> updateFix010(Map<String, Object> map);
    ResponseEntity<?> getRegFixBaseTm(Map<String, Object> map);
}
