package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051030030Spec {
    ResponseEntity<?> selectGetUserMasterDetail(Map<String, Object> map);
}
