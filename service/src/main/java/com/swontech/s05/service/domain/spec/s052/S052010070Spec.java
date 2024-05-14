package com.swontech.s05.service.domain.spec.s052;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface S052010070Spec {
    ResponseEntity<?> getUserList(Map<String, Object> map);

    ResponseEntity<?> deleteUser(ArrayList<Map<String,Object>> array);

    ResponseEntity<?> saveUser(ArrayList<Map<String,Object>> array);

    ResponseEntity<?> saveEMUser(ArrayList<Map<String,Object>> array);


}
