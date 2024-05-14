package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051020010Spec;
import com.swontech.s05.service.repository.s051.S051020010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class S051020010Logic implements S051020010Spec {

    private final S051020010Repository repository;
    private final CustomResponse response;

    public S051020010Logic(S051020010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveLoginInfo(Map<String, Object> map) {
        List<Map<String, Object>> resultList = repository.retrieveLoginInfo(map);
        for (Map<String, Object> resultMap : resultList) {
            if (resultMap != null) {
                if (resultMap.get("pushToken") == null) {
                    map.put("userId", resultMap.get("userId"));
                    repository.updatePushToken(map);
                } else if (map.get("pushToken") != null && map.get("pushToken") != "" && !resultMap.get("pushToken").equals(map.get("pushToken"))) {
                    map.put("userId", resultMap.get("userId"));
                    repository.updatePushToken(map);
                }
            }
        }
        return response.success("retrieveLoginInfo", resultList);
    }

}
