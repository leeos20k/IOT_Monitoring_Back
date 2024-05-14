package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052030230Spec {
    ResponseEntity<?> getYearOpTm(Map<String, Object> map);
    ResponseEntity<?> getMonthOpTm(Map<String, Object> map);
}
