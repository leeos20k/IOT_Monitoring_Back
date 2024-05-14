package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomException;
import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.common.ExceptionEnum;
import com.swontech.s05.service.domain.spec.s052.S052030070Spec;
import com.swontech.s05.service.repository.s052.S052030070Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S052030070Logic implements S052030070Spec {

    private final S052030070Repository repository;
    private final CustomResponse response;

    public S052030070Logic(S052030070Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveArarmList(Map<String, Object> map) {
        return response.success("retrieveArarmList", repository.retrieveArarmList(map));
    }

    @Override
    public ResponseEntity<?> retrieveArarmGraph(Map<String, Object> map) {
        return response.success("retrieveArarmGraph", repository.retrieveArarmGraph(map));
    }

    @Override
    public ResponseEntity<?> deleteAlarm(List<Map<String, Object>> list){

        try{
            for (Map<String, Object> map : list){
                Map<String, Object> map2 = new HashMap<>();
                if(map.get("slaveId") != null && map.get("seq") != null && map.get("alarmEndTm") != null){
                    map2.put("slaveId", map.get("slaveId"));
                    map2.put("seq", map.get("seq"));
                    map2.put("alarmEndTm", map.get("alarmEndTm"));

                    repository.deleteAlarm(map2);
                }
            }

        }catch(CustomException e){
            throw new CustomException(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }


        return response.success("Success");
    }
}
