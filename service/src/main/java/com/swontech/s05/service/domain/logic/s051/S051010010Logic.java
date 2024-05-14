package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051010010Spec;
import com.swontech.s05.service.repository.s051.S051010010Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class S051010010Logic implements S051010010Spec {
    private final S051010010Repository repository;
    private final CustomResponse res;

    public S051010010Logic(S051010010Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> selectGetAreaList(Map<String, Object> map) {
        List<Map<String, Object>> resList = repository.selectGetAreaList(map);
        return res.success("구역관리 조회",resList);
    }

    @Override
    public ResponseEntity<?> deleteArea(Map<String, Object> map) {
        int result = 0;
        System.out.println("데이터 : " + map);
        String rsMsg = "구역삭제 중 오류가 발생했습니다.";
        result = repository.deleteArea(map);
        if (result > 0) rsMsg = "교육이 삭제되었습니다.";

        return res.success(rsMsg);
    }
}
