package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S052030070Spec {

    ResponseEntity<?> retrieveArarmList(Map<String, Object> map);

    ResponseEntity<?> retrieveArarmGraph(Map<String, Object> map);

    ResponseEntity<?> deleteAlarm(List<Map<String, Object>> list);

}
