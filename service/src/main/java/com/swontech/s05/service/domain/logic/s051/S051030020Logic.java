package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051030020Spec;
import com.swontech.s05.service.repository.s051.S051030020Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class S051030020Logic implements S051030020Spec {
    private final S051030020Repository repository;
    private final CustomResponse res;

    public S051030020Logic(S051030020Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> selectGetUserMasterList(Map<String, Object> map) {
        List<Map<String, Object>> resList = repository.selectGetUserMasterList(map);
        return res.success("담당자별 Master 조회",resList);
    }
}
