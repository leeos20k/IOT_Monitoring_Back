package com.swontech.s05.service.domain.spec.s050;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S050010010Spec {

    ResponseEntity<?> retrieveOrgList(Map<String, Object> map);
    ResponseEntity<?> deleteOrg(List<Integer> list);

}
