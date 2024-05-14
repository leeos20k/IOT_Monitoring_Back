package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030012Spec;
import com.swontech.s05.service.domain.spec.s052.S052030013Spec;
import com.swontech.s05.service.repository.s052.S052030012Repository;
import com.swontech.s05.service.repository.s052.S052030013Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class S052030013Logic implements S052030013Spec {

    private final S052030013Repository repository;
    private final CustomResponse response;

    public S052030013Logic(S052030013Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> getSelectableGroup(){
        return response.success("getSelectableGroup", repository.getSelectableGroup());
    }


    @Override
    public ResponseEntity<?> getWaterRate(Map<String, Object> map){
        return response.success("getWaterRate", repository.getWaterRate(map));
    }

    @Override
    public ResponseEntity<?> updateWaterRate(List<Map<String, Object>> list){
        return response.success("updateWaterRate", repository.updateWaterRate(list));
    }

    @Override
    public ResponseEntity<?> updateAggre011(Map<String, Object> map){
        return response.success("updateAggre011", repository.updateAggre011(map));
    }


}
