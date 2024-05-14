package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052020020Spec;
import com.swontech.s05.service.repository.s052.S052020020Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class S052020020Logic implements S052020020Spec {
    private final S052020020Repository repository;
    private final CustomResponse res;

    public S052020020Logic(S052020020Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getLevelInfo(Map<String, Object> map) {
        List<Map<String, Object>> slaveName = repository.getSlaveName(map);
        List<Map<String, Object>> levelValue = repository.getLevelValue(map);
        ArrayList<List<Map<String, Object>>> resList = new ArrayList<>();
        resList.add(slaveName);
        resList.add(levelValue);
        return res.success("레벨 진행 추이도 조회",resList);
    }
}
