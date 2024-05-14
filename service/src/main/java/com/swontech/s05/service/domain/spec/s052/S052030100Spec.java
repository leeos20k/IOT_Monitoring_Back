package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S052030100Spec {

    ResponseEntity<?> getProductionPlan(Map<String, Object> map);

    ResponseEntity<?> delSaveProductionPlan(List<Map<String, Object>> list);

}
