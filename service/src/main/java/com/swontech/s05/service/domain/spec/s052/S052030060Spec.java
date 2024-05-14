package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052030060Spec {

    ResponseEntity<?> retrieveAppMasterLov(Map<String, Object> map);

    ResponseEntity<?> retrieveAppSlaveList(Map<String, Object> map);

    ResponseEntity<?> retrieveSlaveGraph(Map<String, Object> map);

}
