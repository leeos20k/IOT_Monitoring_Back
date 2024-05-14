package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030011Spec;
import com.swontech.s05.service.repository.s052.S052030010Repository;
import com.swontech.s05.service.repository.s052.S052030011Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class S052030011Logic implements S052030011Spec {

    private final S052030011Repository repository;
    private final CustomResponse response;

    public S052030011Logic(S052030011Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> GetEnergyList(Map<String, Object> map){
        return response.success("GetEnergyList", repository.GetEnergyList(map));
    }

    @Override
    public ResponseEntity<?> GetEnergyListPL(Map<String, Object> map){
        return response.success("GetEnergyListPL", repository.GetEnergyListPL(map));
    }

    @Override
    public ResponseEntity<?> GetEnergyListRS(Map<String, Object> map){
        return response.success("GetEnergyListRS", repository.GetEnergyListRS(map));
    }

    @Override
    public ResponseEntity<?> GetEnergyListRSNV(Map<String, Object> map){
        System.out.println("logiccccccccccccccccccccccc");
        return response.success("GetEnergyListRSNV", repository.GetEnergyListRSNV(map));
    }



    @Override
    public ResponseEntity<?> GetEnergyPlanList(Map<String, Object> map){
        return response.success("GetEnergySecList", repository.GetEnergyPlanList(map));
    }

    @Override
    public ResponseEntity<?> GetEnergyRstProd(Map<String, Object> map){
        return response.success("GetEnergyMinList", repository.GetEnergyRstProd(map));
    }

    @Override
    public ResponseEntity<?> GetEnergyRstLng(Map<String, Object> map){
        return response.success("GetEnergyHourList", repository.GetEnergyRstLng(map));
    }

    @Override
    public ResponseEntity<?> GetEnergyRstPw(Map<String, Object> map){
        return response.success("GetEnergyMonList", repository.GetEnergyRstPw(map));
    }

    @Override
    public ResponseEntity<?> updateWaterAmount(List<Map<String, Object>> list){
        return response.success("updateWaterAmount", repository.updateWaterAmount(list));
    }

    @Override
    public ResponseEntity<?> getWorkingGroupInquiry(){
        return response.success("getWorkingGroupInquiry", repository.getWorkingGroupInquiry());
    }

    @Override
    public ResponseEntity<?> updateAlarmConfirm(Map<String, Object> map){
        return response.success("updateAlarmConfirm", repository.updateAlarmConfirm(map));
    }
}
