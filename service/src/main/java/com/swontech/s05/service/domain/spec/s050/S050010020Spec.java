package com.swontech.s05.service.domain.spec.s050;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S050010020Spec {

    ResponseEntity<?> retrieveOrgDetailHead(Map<String, Object> map);
    ResponseEntity<?> retrieveGetDetailLine(Map<String, Object> map);
    ResponseEntity<?> insertOrg(Map<String, Object> map);
    ResponseEntity<?> updateOrg(Map<String, Object> map);

}
