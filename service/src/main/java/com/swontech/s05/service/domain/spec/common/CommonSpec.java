package com.swontech.s05.service.domain.spec.common;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CommonSpec {
    ResponseEntity<?> getTreeMenu(Map<String, Object> map);
    ResponseEntity<?> getFootAlarm(Map<String, Object> map);
    ResponseEntity<?> getFootAlarmCnt(Map<String, Object> map);
}
