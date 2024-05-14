package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051030020Spec {
    ResponseEntity<?> selectGetUserMasterList(Map<String, Object> map);
}
