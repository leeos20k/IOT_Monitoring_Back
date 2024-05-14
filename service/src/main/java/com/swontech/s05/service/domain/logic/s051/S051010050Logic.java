package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051010050Spec;
import com.swontech.s05.service.repository.s051.S051010050Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class S051010050Logic implements S051010050Spec {
    private final S051010050Repository repository;
    private final CustomResponse res;

    public S051010050Logic(S051010050Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> selectGetMasterList(Map<String, Object> map) {
        List<Map<String, Object>> resList = repository.selectGetMasterList(map);
        return res.success("Master 조회",resList);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteMaster(Map<String, Object> map) {
        int result = 0;
        System.out.println("데이터 : " + map);
        String rsMsg = "마스터삭제 중 오류가 발생했습니다.";
        repository.deleteSw(map);
        result = repository.deleteMaster(map);
        if (result > 0) rsMsg = "마스터가 삭제되었습니다.";

        return res.success(rsMsg);
    }
}
