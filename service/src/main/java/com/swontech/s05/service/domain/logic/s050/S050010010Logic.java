package com.swontech.s05.service.domain.logic.s050;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s050.S050010010Spec;
import com.swontech.s05.service.repository.s050.S050010010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S050010010Logic implements S050010010Spec {

    private final S050010010Repository repository;
    private final CustomResponse response;

    public S050010010Logic(S050010010Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveOrgList(Map<String, Object> map) {
        return response.success("retrieveOrgList", repository.selectGetOrgList(map));
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteOrg(List<Integer> list) {
        String message = "Fail";
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        repository.deleteApp(map);
        int result = repository.deleteOrg(map);
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }

}
