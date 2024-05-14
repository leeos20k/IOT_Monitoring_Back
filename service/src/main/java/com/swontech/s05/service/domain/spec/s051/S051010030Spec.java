package com.swontech.s05.service.domain.spec.s051;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface S051010030Spec {

    ResponseEntity<?> retrieveUserList(Map<String, Object> map);
    ResponseEntity<?> updateAdmin(Map<String, Object> map);
    ResponseEntity<?> endUser(int loginId, List<Integer> list);

}
