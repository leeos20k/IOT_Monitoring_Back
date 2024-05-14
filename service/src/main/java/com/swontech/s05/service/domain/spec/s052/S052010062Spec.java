package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052010062Spec {
    ResponseEntity<?> getSlaveDetail(Map<String, Object> map);
    ResponseEntity<?> insertSlave(Map<String, Object> map);
    ResponseEntity<?> updateSlave(Map<String, Object> map);
    ResponseEntity<?> retrieveSlaveTp();
}
