package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051030030Spec;
import com.swontech.s05.service.repository.s051.S051030030Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class S051030030Logic implements S051030030Spec {
    private final S051030030Repository repository;
    private final CustomResponse res;

    public S051030030Logic(S051030030Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> selectGetUserMasterDetail(Map<String, Object> map) {
        List<Map<String, Object>> resList1 = repository.selectGetMasterDetailHead(map);
        List<Map<String, Object>> resList2 = repository.selectGetMasterDetailUser(map);
        List<Map<String, Object>> resList3 = repository.selectGetMasterDetailSW(map);
        List<Map<String, Object>>[] resultListArray = new List[3];
        resultListArray[0] = resList1;
        resultListArray[1] = resList2;
        resultListArray[2] = resList3;
        return res.success("담당자별 Master 상세조회",resultListArray);
    }
}
