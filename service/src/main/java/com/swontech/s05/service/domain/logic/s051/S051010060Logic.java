package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s051.S051010060Spec;
import com.swontech.s05.service.repository.s051.S051010060Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class S051010060Logic implements S051010060Spec {
    private final S051010060Repository repository;
    private final CustomResponse res;

    public S051010060Logic(S051010060Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> selectGetMasterDetail(Map<String, Object> map) {
        List<Map<String, Object>> resList = repository.selectGetMasterDetail(map);
        return res.success("마스터 상세조회",resList);
    }

    @Override
    @Transactional
    public ResponseEntity<?> insertMaster(Map<String, Object> map) {
        System.out.println("insert 데이터: "+map);
        int reuslt= 0,err = 0;
        String rsMsg = "마스터등록 중 오류가 발생했습니다.";

        if(!map.containsKey("swCnt")) return res.success("스위치갯수가 없습니다.");
        reuslt = repository.insertMaster(map);
        String swCntString = String.valueOf(map.get("swCnt"));
        int swCnt = Integer.parseInt(swCntString);
        err = insertSwitch(map, swCnt);

        if (err == 0 && reuslt > 0) rsMsg = "마스터가 등록되었습니다.";
        return res.success(rsMsg);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateMaster(Map<String, Object> map) {
            int updateResult = 0, deleteResult = 0, err = 0;
            String rsMsg = "마스터수정 중 오류가 발생했습니다.";
        System.out.println("update 데이터: "+map);
        try{
            if(!map.containsKey("masterId")) return res.success("masterId가 없습니다.");
            if(!map.containsKey("swCnt")) return res.success("스위치갯수가 없습니다.");
            updateResult = repository.updateMaster(map);
            deleteResult = repository.deleteMaster(map);
            String swCntString = String.valueOf(map.get("swCnt"));
            int swCnt = Integer.parseInt(swCntString);
            err = insertSwitch(map, swCnt);
            System.out.println("update결과: "+"upd: "+deleteResult + ", del: "+updateResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
            if (err == 0 && updateResult > 0) rsMsg = "마스터가 수정되었습니다.";
            return res.success(rsMsg);
    }

    @Transactional
    public int insertSwitch(Map<String, Object> map, int swCnt) {
        System.out.println("insertSW 데이터: "+map);
        int err = 0;
        for (int i = 0; i < swCnt; i++) {
            map.remove("swNo");
            map.put("swNo", i + 1);
            repository.insertSwitch(map);
        }
        return err;
    }
}
