package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030010Spec;
import com.swontech.s05.service.repository.s052.S052030010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class S052030010Logic implements S052030010Spec {

    private final S052030010Repository repository;
    private final CustomResponse response;

    public S052030010Logic(S052030010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveMasterList(Map<String, Object> map) {
        if (map.get("slaveTp") != null && map.get("slaveTp").equals("")) {
            map.put("slaveTp", null);
        }
        return response.success("retrieveMasterList", repository.retrieveMasterList(map));
    }

    @Override
    public ResponseEntity<?> retrieveSlaveDataList(Map<String, Object> map){
        return response.success("retrieveSlaveDataList", repository.retrieveSlaveDataList(map));
    }

    @Override
    public ResponseEntity<?> retrieveSlaveGroupName(Map<String, Object> map){
        return response.success("retrieveSlaveGroupName", repository.retrieveSlaveGroupName(map));
    }

    @Override
    public ResponseEntity<?> retrieveSlaveMnMx(Map<String, Object> map){
        return response.success("retrieveSlaveMnMx", repository.retrieveSlaveMnMx(map));
    }

    @Override
    public ResponseEntity<?> retrieveImage(Map<String, Object> map) {
        Map<String, Object> paramsMap = repository.retrieveImage(map);
        if (paramsMap.get("attachFile") != null && !paramsMap.get("attachFile").equals("")) {
            byte[] bytes = (byte[]) paramsMap.get("attachFile");
            String newBytes = new String(bytes);
            paramsMap.replace("attachFile", newBytes);
        } else {
            paramsMap.replace("attachFile", null);
        }
        return response.success("retrieveImage", paramsMap);
    }

    @Override
    public ResponseEntity<?> updateAlarm020(Map<String, Object> map){
        return response.success("updateAlarm020", repository.updateAlarm020(map));
    }
    @Override
    public ResponseEntity<?> updateAlarm030(Map<String, Object> map){
        return response.success("updateAlarm030", repository.updateAlarm030(map));
    }






    @Override
    public ResponseEntity<?> csvReadTest(Map<String, Object> map){
        return response.success("csvReadTest", repository.csvReadTest(map));
    }
//    @Override
//    public ResponseEntity<?> manyDataTest(Map<String, Object> map){
//        return response.success("manyDataTest", repository.manyDataTest(map));
//    }



}
