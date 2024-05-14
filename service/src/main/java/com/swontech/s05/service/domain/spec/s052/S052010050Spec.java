package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S052010050Spec {

    ResponseEntity<?> retrieveSlaveList(Map<String, Object> map);

    ResponseEntity<?> retrieveEMSlaveList(Map<String, Object> map);

    ResponseEntity<?> deleteSlave(List<Integer> list);

}
