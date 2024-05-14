package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface S052030010Spec {

    ResponseEntity<?> retrieveMasterList(Map<String, Object> map);
    ResponseEntity<?> retrieveSlaveDataList(Map<String, Object> map);
    ResponseEntity<?> retrieveSlaveGroupName(Map<String, Object> map);
    ResponseEntity<?> retrieveSlaveMnMx(Map<String, Object> map);
    ResponseEntity<?> retrieveImage(Map<String, Object> map);
    ResponseEntity<?> updateAlarm020(Map<String, Object> map);
    ResponseEntity<?> updateAlarm030(Map<String, Object> map);


    ResponseEntity<?> csvReadTest(Map<String, Object> map);

//        ResponseEntity<?>  manyDataTest(Map<String, Object> map);
}
