package com.swontech.s05.service.domain.spec.s052;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface S052030011Spec {

    ResponseEntity<?> GetEnergyList(Map<String, Object> map);

    ResponseEntity<?> GetEnergyListPL(Map<String, Object> map);
    ResponseEntity<?> GetEnergyListRS(Map<String, Object> map);
    ResponseEntity<?> GetEnergyListRSNV(Map<String, Object> map);

    ResponseEntity<?> GetEnergyPlanList(Map<String, Object> map);

    ResponseEntity<?> GetEnergyRstProd(Map<String, Object> map);

    ResponseEntity<?> GetEnergyRstLng(Map<String, Object> map);

    ResponseEntity<?> GetEnergyRstPw(Map<String, Object> map);

    ResponseEntity<?> updateWaterAmount(List<Map<String, Object>> list);

    ResponseEntity<?> getWorkingGroupInquiry();

    ResponseEntity<?> updateAlarmConfirm(Map<String, Object> map);

}
