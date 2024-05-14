package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030210Spec;
import com.swontech.s05.service.repository.s052.S052030210Repository;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class S052030210Logic implements S052030210Spec {

    private final S052030210Repository repository;
    private final CustomResponse res;

    public S052030210Logic(S052030210Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getRegFixMgn(Map<String, Object> map) {
        return res.success("getRegFixMgn", repository.getRegFixMgn(map));
    }

    @Override
    public ResponseEntity<?> insertFix010(Map<String, Object> map) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateFix010(Map<String, Object> map) {
        return null;
    }

    @Override
    public ResponseEntity<?> getRegFixBaseTm(Map<String, Object> map) {
        return res.success("getRegFixBaseTm", repository.getRegFixBaseTm(map));
    }
}
