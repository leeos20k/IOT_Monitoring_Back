package com.swontech.s05.service.domain.logic.s054;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s054.S054030030Spec;
import com.swontech.s05.service.repository.s054.S054030010Repository;
import com.swontech.s05.service.repository.s054.S054030030Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S054030030Logic implements S054030030Spec {
    private final S054030030Repository repository;
    private final CustomResponse response;

    public S054030030Logic(S054030030Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> getLevelInfo(Map<String, Object> map) {
        return response.success("getLevelInfo", repository.getLevelInfo(map));
    }

    @Override
    public ResponseEntity<?> getYMinMax(Map<String, Object> map) {
        return response.success("getYMinMax", repository.getYMinMax(map));
    }

    @Override
    public ResponseEntity<?> getAlarmLine(Map<String, Object> map) {
        return response.success("getAlarmLine", repository.getAlarmLine(map));
    }
}
