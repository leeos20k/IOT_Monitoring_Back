package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051010040Spec;
import com.swontech.s05.service.repository.s051.S051010040Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class S051010040Logic implements S051010040Spec {

    private final S051010040Repository repository;
    private final CustomResponse response;

    public S051010040Logic(S051010040Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveUser(Map<String, Object> map) {
        return response.success("retrieveUser", repository.getUser(map));
    }

    @Override
    public ResponseEntity<?> retrieveUserDetail(Map<String, Object> map) {
        return response.success("retrieveUserDetail", repository.getUserDetail(map));
    }

    @Override
    @Transactional
    public ResponseEntity<?> insertUser(Map<String, Object> map) {
        String message = "Fail";
        Map<String, Object> infoMap = (Map<String, Object>) map.get("info");
        infoMap.replace("hpNo", String.valueOf(infoMap.get("hpNo")).substring(0, 3) + "-" + String.valueOf(infoMap.get("hpNo")).substring(3, 7) + "-" + String.valueOf(infoMap.get("hpNo")).substring(7));
        int result = repository.insertUser(infoMap);
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("list");
        for (Map<String, Object> stringObjectMap : list) {
            stringObjectMap.put("userId", null);
            stringObjectMap.put("orgId", infoMap.get("orgId"));
            stringObjectMap.put("loginId", infoMap.get("loginId"));
            repository.insertMaster(stringObjectMap);
        }
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateUser(Map<String, Object> map) {
        String message = "Fail";
        Map<String, Object> infoMap = (Map<String, Object>) map.get("info");
        infoMap.replace("hpNo", String.valueOf(infoMap.get("hpNo")).substring(0, 3) + "-" + String.valueOf(infoMap.get("hpNo")).substring(3, 7) + "-" + String.valueOf(infoMap.get("hpNo")).substring(7));
        int result = repository.updateUser(infoMap);
        repository.deleteUserMater(infoMap);
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("list");
        for (Map<String, Object> stringObjectMap : list) {
            stringObjectMap.put("userId", infoMap.get("userId"));
            stringObjectMap.put("orgId", infoMap.get("orgId"));
            stringObjectMap.put("loginId", infoMap.get("loginId"));
            repository.insertMaster(stringObjectMap);
        }
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }
}
