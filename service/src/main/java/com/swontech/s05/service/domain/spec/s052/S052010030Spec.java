package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface S052010030Spec {
    ResponseEntity<?> getMasterList(Map<String, Object> map);
    ResponseEntity<?> deleteMaster(ArrayList<String> array);
}
