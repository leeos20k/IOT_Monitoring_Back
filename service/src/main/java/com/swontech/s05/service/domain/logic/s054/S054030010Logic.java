package com.swontech.s05.service.domain.logic.s054;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s054.S054030010Spec;
import com.swontech.s05.service.repository.s052.S052030010Repository;
import com.swontech.s05.service.repository.s054.S054030010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S054030010Logic implements S054030010Spec {
    private final S054030010Repository repository;
    private final CustomResponse response;

    public S054030010Logic(S054030010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveMasterList(Map<String, Object> map) {
        return response.success("retrieveMasterList", repository.retrieveMasterList(map));
    }
}
