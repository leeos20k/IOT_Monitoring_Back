package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomException;
import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010030Spec;
import com.swontech.s05.service.repository.s052.S052010030Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S052010030Logic implements S052010030Spec {
    private final S052010030Repository repository;
    private final CustomResponse res;

    public S052010030Logic(S052010030Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getMasterList(Map<String, Object> map) {
        List<Map<String, Object>> result = repository.getMasterList(map);
        return res.success("Master 조회",result);
    }

    @Override
    public ResponseEntity<?> deleteMaster(ArrayList<String> array) {
        int delSlaveResult = 0, delMasterResult = 0;
        String result = "마스터 삭제중 오류가 발생했습니다.";
    try {
        for (String masterId : array) {
            Map<String, Object> map = new HashMap<>();
            map.put("masterId", masterId);
            delSlaveResult = repository.deleteSlave(map);
            delMasterResult = repository.deleteMaster(map);
        }
    } catch (CustomException e) {
        res.fail(e);
    }
//        if (delMasterResult > 0 && delSlaveResult > 0)
            result = "성공적으로 삭제했습니다.";
        return res.success(result);
    }
}
