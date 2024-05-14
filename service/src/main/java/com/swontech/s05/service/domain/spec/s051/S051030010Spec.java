package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051030010Spec {

    ResponseEntity<?> retrieveAreaMasterStatus(Map<String, Object> map);
    ResponseEntity<?> retrieveAreaMasterDetail(Map<String, Object> map);

}
