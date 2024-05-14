package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030060Spec;
import com.swontech.s05.service.repository.s052.S052030060Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S052030060Logic implements S052030060Spec {

    private final S052030060Repository repository;
    private final CustomResponse response;

    public S052030060Logic(S052030060Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveAppMasterLov(Map<String, Object> map) {
        return response.success("retrieveAppMasterLov", repository.retrieveAppMasterLov(map));
    }

    @Override
    public ResponseEntity<?> retrieveAppSlaveList(Map<String, Object> map) {
        return response.success("retrieveAppSlaveList", repository.retrieveAppSlaveList(map));
    }

    @Override
    public ResponseEntity<?> retrieveSlaveGraph(Map<String, Object> map) {
        return response.success("retrieveSlaveGraph", repository.retrieveSlaveGraph(map));
    }

}
