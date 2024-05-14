package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052010020Spec {

    ResponseEntity<?> retrieveGroupDetail(Map<String, Object> map);
    ResponseEntity<?> registerGroup(Map<String, Object> map);

}
