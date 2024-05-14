package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030010Spec;
import com.swontech.s05.service.domain.spec.s052.S052030100Spec;
import com.swontech.s05.service.repository.s052.S052030010Repository;
import com.swontech.s05.service.repository.s052.S052030100Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S052030100Logic implements S052030100Spec {

    private final S052030100Repository repository;
    private final CustomResponse response;

    public S052030100Logic(S052030100Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> getProductionPlan(Map<String, Object> map) {
        return response.success("getProductionPlan", repository.getProductionPlan(map));
    }

    @Override
    public ResponseEntity<?> delSaveProductionPlan(List<Map<String, Object>> list) {
        return response.success("delSaveProductionPlan", repository.delSaveProductionPlan(list));
    }
}
