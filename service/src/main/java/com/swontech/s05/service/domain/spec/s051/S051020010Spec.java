package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S051020010Spec {

    ResponseEntity<?> retrieveLoginInfo(Map<String, Object> map);

}
