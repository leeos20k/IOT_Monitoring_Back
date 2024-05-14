package com.swontech.s05.service.domain.spec.s054;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S054030030Spec {
    ResponseEntity<?> getLevelInfo(Map<String, Object> map);
    ResponseEntity<?> getYMinMax(Map<String, Object> map);
    ResponseEntity<?> getAlarmLine(Map<String, Object> map);
}
