package com.swontech.s05.service.domain.spec.s052;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S052030013Spec {

    ResponseEntity<?> getSelectableGroup();
    ResponseEntity<?> getWaterRate(Map<String, Object> map);

    ResponseEntity<?> updateWaterRate(List<Map<String, Object>> list);

    ResponseEntity<?> updateAggre011(Map<String, Object> map);

}
