package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface S051010020Spec {
    ResponseEntity<?> selectGetAreaDetail(Map<String, Object> map);
    int selectGetAreaSeq(Map<String, Object> map);
    ResponseEntity<?> insertArea(Map<String, Object> map, ArrayList<Integer> masterId);
    ResponseEntity<?> updateArea(Map<String, Object> map,ArrayList<Integer> masterId);
}
