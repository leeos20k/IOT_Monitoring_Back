package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051010030Spec;
import com.swontech.s05.service.repository.s051.S051010030Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S051010030Logic implements S051010030Spec {

    private final S051010030Repository repository;
    private final CustomResponse response;

    public S051010030Logic(S051010030Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveUserList(Map<String, Object> map) {
        if (map.get("adminFlag").equals("")) {
            map.replace("adminFlag", null);
        }
        return response.success("retrieveUserList", repository.retrieveUserList(map));
    }

    @Override
    public ResponseEntity<?> updateAdmin(Map<String, Object> map) {
        String message = "Fail";
        if (map.get("adminFlag").equals("N")) {
            map.replace("adminFlag", null);
        }
        int result = repository.updateAdmin(map);
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }

    @Override
    @Transactional
    public ResponseEntity<?> endUser(int loginId, List<Integer> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginId", loginId);
        map.put("list", list);
        System.out.println(list);
        String message = "Fail";
        int result = repository.endUser(map);
        repository.deleteMaster(map);
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }
}
