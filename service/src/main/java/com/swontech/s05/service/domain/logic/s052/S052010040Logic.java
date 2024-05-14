package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomException;
import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010040Spec;
import com.swontech.s05.service.repository.s052.S052010040Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class S052010040Logic implements S052010040Spec {
    private final S052010040Repository repository;
    private final CustomResponse res;

    public S052010040Logic(S052010040Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getMasterDetail(Map<String, Object> map) {
        List<Map<String, Object>> headList = repository.getMasterDetailHead(map);
        List<Map<String, Object>> lineList = repository.getMasterDetailLine(map);
        ArrayList<List<Map<String, Object>>> resList = new ArrayList<>();
        resList.add(headList);
        resList.add(lineList);
        return res.success("마스터 상세조회",resList);
    }

    @Override
    @Transactional
    public ResponseEntity<?> insertMaster(Map<String, Object> map) {
        int masterResult = 0, slavesResult = 0;
        String rsMsg ="마스터 등록중 오류가 발생했습니다.";
        List<Map<String, Object>> list = map.containsKey("list") ? (List<Map<String, Object>>) map.get("list") : Collections.emptyList();

        try{
            map.put("socketMth", "TCP");
            map.put("reconnect", 1);
            map.put("timeout", 3000);
            masterResult = repository.insertMaster(map);
            int seq = 1;
            for (Map<String, Object> slave : list) {
                slave.put("seq", seq);
                int slaveResult = repository.insertSlave(slave);
                seq++;
                slavesResult += slaveResult;
                if (slaveResult < 1) throw new RuntimeException();
            }
            if (masterResult < 1 ) throw new RuntimeException();
        } catch (CustomException e ){
            res.fail(e);
            throw new RuntimeException();
        }

//        if( masterResult > 0 && slavesResult > 0 )
            rsMsg = "마스터가 등록 됐습니다.";
        return res.success(rsMsg);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateMaster(Map<String, Object> map) {
        int deleteSlaveResult = 0;
        int updateSlavesResult = 0;
        int updateMasterResult = 0;
        String rsMsg ="마스터 수정중 오류가 발생했습니다.";
        List<Map<String, Object>> list = map.containsKey("list") ? (List<Map<String, Object>>) map.get("list") : Collections.emptyList();
        String masterId = String.valueOf(map.get("masterId"));
        deleteSlaveResult=repository.deleteSlave(map);
        int seq = 1;
        for (Map<String, Object> slave : list) {
            slave.put("masterId", masterId);
            slave.put("seq", seq);
            int slaveResult = repository.updateSlave(slave);
            seq++;
            updateSlavesResult += slaveResult;
            if (slaveResult < 1) throw new RuntimeException();
        }
        updateMasterResult = repository.updateMaster(map);

        if (updateMasterResult < 1 ) throw new RuntimeException();

//        if( deleteSlaveResult > 0 && updateMasterResult > 0 )
            rsMsg = "마스터가 수정 됐습니다.";
        return res.success(rsMsg);
    }
}
