package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010010Spec;
import com.swontech.s05.service.repository.s052.S052010010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S052010010Logic implements S052010010Spec {

    private final S052010010Repository repository;
    private final CustomResponse response;

    public S052010010Logic(S052010010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveGroupList(Map<String, Object> map) {
        return response.success("retrieveGroupList", repository.retrieveGroupList(map));
    }

    @Override
    public ResponseEntity<?> deleteGroup(Map<String, Object> map) {
        String message = "Fail";
        int result = 0;
        List<String> list = (List<String>) map.get("list");
        for (String stringObjectMap : list) {
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put("orgId", map.get("orgId"));
            paramsMap.put("appTp", map.get("appTp"));
            paramsMap.put("areaSeq", stringObjectMap);
            result = result + repository.deleteGroup(paramsMap);
        }
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }

}
