package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010050Spec;
import com.swontech.s05.service.repository.s052.S052010050Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S052010050Logic implements S052010050Spec {

    private final S052010050Repository repository;
    private final CustomResponse response;

    public S052010050Logic(S052010050Repository repository, CustomResponse response) {
        this.repository = repository;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveSlaveList(Map<String, Object> map) {
        return response.success("retrieveSlaveList", repository.retrieveSlaveList(map));
    }

    @Override
    public ResponseEntity<?> retrieveEMSlaveList(Map<String, Object> map) {
        return response.success("retrieveEMSlaveList", repository.retrieveEMSlaveList(map));
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteSlave(List<Integer> list) {
        String message = "Fail";
        int result = 0;
        for (Integer integer : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("slaveId", integer);
            if (repository.getMaster020(map).size() != 0) {
                repository.deleteSlave(map);
            }
            repository.deleteSlaveSeq(map);
            result = repository.deleteSlaveHeader(map);
        }
        if (result > 0) {
            message = "Success";
        }
        return response.success(message);
    }

}
