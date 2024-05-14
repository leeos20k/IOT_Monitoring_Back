package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051010010Spec {
    ResponseEntity<?> selectGetAreaList(Map<String, Object> map);
    ResponseEntity<?> deleteArea(Map<String, Object> map);
}
