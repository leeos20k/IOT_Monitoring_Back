package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051030010Spec;
import com.swontech.s05.service.repository.s051.S051030010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S051030010Logic implements S051030010Spec {

    private final S051030010Repository repository;
    private final CustomResponse response;

    public S051030010Logic(S051030010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveAreaMasterStatus(Map<String, Object> map) {
        return response.success("retrieveAreaMasterStatus", repository.retrieveAreaMasterStatus(map));
    }

    @Override
    public ResponseEntity<?> retrieveAreaMasterDetail(Map<String, Object> map) {
        return response.success("retrieveAreaMasterDetail", repository.retrieveAreaMasterDetail(map));
    }
}
