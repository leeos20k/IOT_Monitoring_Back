package com.swontech.s05.service.domain.spec.s052;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface S052030012Spec {

    ResponseEntity<?> getSelectableGroup();

    ResponseEntity<?> getEnergyProdListPlan(Map<String, Object> map);

    ResponseEntity<?> getEnergyProdListRst(Map<String, Object> map);

    ResponseEntity<?> getEnergyProdExcel(Map<String, Object> map);

}
