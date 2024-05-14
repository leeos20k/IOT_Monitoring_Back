package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051010020Spec;
import com.swontech.s05.service.repository.s051.S051010020Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class S051010020Logic implements S051010020Spec {
    private final S051010020Repository repository;
    private final CustomResponse res;

    public S051010020Logic(S051010020Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }


    @Override
    public ResponseEntity<?> selectGetAreaDetail(Map<String, Object> map) {
        List<Map<String, Object>> resList = repository.selectGetAreaDetail(map);
        return res.success("구역관리 상세조회",resList);
    }

    @Override
    public int selectGetAreaSeq(Map<String, Object> map) {
        Map<String, Object> result = repository.selectGetAreaSeq(map);
        Long areaSeqLong = (Long) result.get("areaSeq");
        int areaSeq = areaSeqLong.intValue();
        return  areaSeq;
    }

    @Override
    @Transactional
    public ResponseEntity<?> insertArea(Map<String, Object> map, ArrayList<Integer> masterId) {
        int err = 0;
        String rsMsg = "구역등록 중 오류가 발생했습니다.";
        if (masterId.size() == 0  ) {
            return res.success("마스터를 선택해주세요.");
        }
        int areaSeq = selectGetAreaSeq(map);
        map.put("areaSeq", areaSeq);
        try{
            masterId.forEach(id -> {
                int result = 0;
                map.remove("masterId");
                map.put("masterId", id);
                result = repository.insertArea(map);
                if(result == 0) throw new RuntimeException("An error occurred while inserting areas.");
            });
        } catch (Exception e) {
            err++;
        }
        if (err == 0) rsMsg = "구역이 등록되었습니다.";
        return res.success(rsMsg);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateArea(Map<String, Object> map,ArrayList<Integer> masterId) {
        int err = 0;
        String rsMsg = "구역수정 중 오류가 발생했습니다.";
        if (masterId.size() == 0) {
            return res.success("마스터를 선택 해주세요.");
        }
        int deleteResult = repository.deleteArea(map);
        if (deleteResult == 0) {
            return res.success(rsMsg); // or handle the failure accordingly
        }
        try {
            masterId.forEach(id -> {
                map.remove("masterId");
                map.put("masterId", id);
                int result = repository.insertArea(map);
                if (result == 0) throw new RuntimeException("An error occurred while inserting areas.");
            });
        } catch (Exception e) {
            err++;
        }
        if (err == 0) {
            rsMsg = "구역이 수정되었습니다.";
        }
        return res.success(rsMsg);
    }
}
