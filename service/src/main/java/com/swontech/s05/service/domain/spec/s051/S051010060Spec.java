package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051010060Spec {
    ResponseEntity<?> selectGetMasterDetail(Map<String, Object> map);
    ResponseEntity<?> insertMaster(Map<String, Object> map);
    ResponseEntity<?> updateMaster(Map<String, Object> map);
}
