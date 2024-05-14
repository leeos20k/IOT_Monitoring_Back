package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010020Spec;
import com.swontech.s05.service.repository.s052.S052010020Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class S052010020Logic implements S052010020Spec {

    private final S052010020Repository repository;
    private final CustomResponse response;

    public S052010020Logic(S052010020Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveGroupDetail(Map<String, Object> map) {
        return response.success("retrieveGroupDetail", repository.retrieveGroupDetail(map));
    }

    @Override
    @Transactional
    public ResponseEntity<?> registerGroup(Map<String, Object> map) {

        String message = "Fail";
        int result = 0;

        Map<String, Object> paramsMap = (Map<String, Object>) map.get("map");
        List<Map<String, Object>> paramsList = (List<Map<String, Object>>) map.get("list");

        if (map.get("updateFlag") != null && map.get("updateFlag").equals("update")) {
            repository.deleteArea(paramsMap);
        }

        Map<String, Object> seqMap = repository.retrieveAreaSeq(paramsMap);
        paramsMap.put("areaSeq", seqMap.get("areaSeq"));

        for (Map<String, Object> stringObjectMap : paramsList) {
            paramsMap.put("masterId", stringObjectMap.get("displayMaId"));
            result = result + repository.insertArea(paramsMap);
        }

        if (result > 0) {
            message = "Success";
        }

        return response.success(message);
    }
}
