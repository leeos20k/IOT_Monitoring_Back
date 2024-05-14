package com.swontech.s05.service.domain.logic.s050;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s050.S050010020Spec;
import com.swontech.s05.service.repository.s050.S050010020Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class S050010020Logic implements S050010020Spec {

    private final S050010020Repository repository;
    private final CustomResponse response;

    public S050010020Logic(S050010020Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveOrgDetailHead(Map<String, Object> map) {
        List<Map<String, Object>> resultList = repository.selectGetOrgDetailHead(map);
        return response.success("retrieveOrgDetailHead", resultList);
    }

    @Override
    public ResponseEntity<?> retrieveGetDetailLine(Map<String, Object> map) {
        return response.success("retrieveGetDetailLine", repository.selectGetOrgDetailLine(map));
    }

    @Override
    @Transactional
    public ResponseEntity<?> insertOrg(Map<String, Object> map) {
        String message = "Fail";
        Map<String, Object> infoMap = (Map<String, Object>) map.get("info");
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("list");
        int result = repository.insertOrg(infoMap);
        for (Map<String, Object> stringObjectMap : list) {
            stringObjectMap.put("userNm", infoMap.get("userNm"));
            stringObjectMap.put("hpNo", String.valueOf(infoMap.get("hpNo")).substring(0, 3) + "-" + String.valueOf(infoMap.get("hpNo")).substring(3, 7) + "-" + String.valueOf(infoMap.get("hpNo")).substring(7));
            repository.insertApp(stringObjectMap);
            repository.insertUser(stringObjectMap);
        }
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateOrg(Map<String, Object> map) {
        String message = "Fail";
        Map<String, Object> infoMap = (Map<String, Object>) map.get("info");
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("list");
        int result = repository.updateOrg(infoMap);
        repository.deleteApp(infoMap);
        for (Map<String, Object> stringObjectMap : list) {
            stringObjectMap.put("orgId", infoMap.get("orgId"));
            repository.insertApp(stringObjectMap);
        }
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }
}
