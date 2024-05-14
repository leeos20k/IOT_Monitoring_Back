package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052010010Spec {

    ResponseEntity<?> retrieveGroupList(Map<String, Object> map);
    ResponseEntity<?> deleteGroup(Map<String, Object> map);

}
