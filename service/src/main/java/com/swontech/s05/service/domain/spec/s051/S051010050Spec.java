package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051010050Spec {
    ResponseEntity<?> selectGetMasterList(Map<String, Object> map);
    ResponseEntity<?> deleteMaster(Map<String, Object> map);
}
