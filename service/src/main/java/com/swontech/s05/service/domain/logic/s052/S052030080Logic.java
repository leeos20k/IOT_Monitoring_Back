package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052030080Spec;
import com.swontech.s05.service.repository.s052.S052030080Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S052030080Logic implements S052030080Spec {

    private final S052030080Repository repository;
    private final CustomResponse response;

    public S052030080Logic(S052030080Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveSlaveLov(Map<String, Object> map) {
        return response.success("retrieveSlaveLov", repository.retrieveSlaveLov(map));
    }

    @Override
    public ResponseEntity<?> retrieveSlaveRippleComp(Map<String, Object> map) {
        List<Map<String, Object>> list1 = repository.retrieveSlaveRippleComp1(map);
        List<Map<String, Object>> list2 = repository.retrieveSlaveRippleComp2(map);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("firstSlave", list1);
        resMap.put("secondSlave", list2);
        return response.success("retrieveSlaveRippleComp", resMap);
    }
}
