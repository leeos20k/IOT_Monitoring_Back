package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052030080Spec {

    ResponseEntity<?> retrieveSlaveLov(Map<String, Object> map);

    ResponseEntity<?> retrieveSlaveRippleComp(Map<String, Object> map);

}
