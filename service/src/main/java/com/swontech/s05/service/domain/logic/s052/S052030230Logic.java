package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030230Spec;
import com.swontech.s05.service.repository.s052.S052030230Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S052030230Logic implements S052030230Spec {

    private final S052030230Repository repository;
    private final CustomResponse res;

    public S052030230Logic(S052030230Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }


    @Override
    public ResponseEntity<?> getYearOpTm(Map<String, Object> map) {
        return res.success("getYearOpTm", repository.getYearOpTm(map));
    }

    @Override
    public ResponseEntity<?> getMonthOpTm(Map<String, Object> map) {
        return res.success("getYearOpTm", repository.getMonthOpTm(map));
    }
}
