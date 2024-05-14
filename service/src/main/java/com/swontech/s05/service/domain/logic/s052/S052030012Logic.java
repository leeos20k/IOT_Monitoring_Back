package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030011Spec;
import com.swontech.s05.service.domain.spec.s052.S052030012Spec;
import com.swontech.s05.service.repository.s052.S052030011Repository;
import com.swontech.s05.service.repository.s052.S052030012Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class S052030012Logic implements S052030012Spec {

    private final S052030012Repository repository;
    private final CustomResponse response;

    public S052030012Logic(S052030012Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> getSelectableGroup(){
        return response.success("getSelectableGroup", repository.getSelectableGroup());
    }

    @Override
    public ResponseEntity<?> getEnergyProdListPlan(Map<String, Object> map){
        return response.success("getEnergyProdListPlan", repository.getEnergyProdListPlan(map));
    }

    @Override
    public ResponseEntity<?> getEnergyProdListRst(Map<String, Object> map){
        return response.success("getEnergyProdListRst", repository.getEnergyProdListRst(map));
    }

    @Override
    public ResponseEntity<?> getEnergyProdExcel(Map<String, Object> map){
        return response.success("getEnergyProdExcel", repository.getEnergyProdExcel(map));
    }

}
