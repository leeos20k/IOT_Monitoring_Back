package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052020010Spec;
import com.swontech.s05.service.repository.s052.S052020010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S052020010Logic implements S052020010Spec {

    private final S052020010Repository repository;
    private final CustomResponse response;

    public S052020010Logic(S052020010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveUser(Map<String, Object> map) {
        map.replace("hpNo", String.valueOf(map.get("hpNo")).substring(0, 3) + "-" + String.valueOf(map.get("hpNo")).substring(3, 7) + "-" + String.valueOf(map.get("hpNo")).substring(7));
        return response.success("retrieveUser", repository.retrieveUser(map));
    }
}
