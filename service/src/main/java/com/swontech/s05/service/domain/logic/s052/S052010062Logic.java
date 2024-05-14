package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomException;
import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010060Spec;
import com.swontech.s05.service.domain.spec.s052.S052010062Spec;
import com.swontech.s05.service.repository.s052.S052010060Repository;
import com.swontech.s05.service.repository.s052.S052010062Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class S052010062Logic implements S052010062Spec {

    private final S052010062Repository repository;
    private final CustomResponse res;

    public S052010062Logic(S052010062Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getSlaveDetail(Map<String, Object> map) {
        List<Map<String, Object>> headList = repository.getSlaveDetailHead(map);
        List<Map<String, Object>> lineList = repository.getSlaveDetailLine(map);
        for (Map<String, Object> item : lineList) {
            if (item.get("attachFile") != null) {
                byte[] arr1 = (byte[]) item.get("attachFile");
                String attachFIle = new String(arr1);
                item.remove("attachFile");
                item.put("attach_file", attachFIle);
            }
        }
        ArrayList<List<Map<String, Object>>> resList = new ArrayList<>();
        resList.add(headList);
        resList.add(lineList);
        return res.success("slave 상세조회", resList);
    }

    @Override
    @Transactional
    public ResponseEntity<?> insertSlave(Map<String, Object> map) {
        int head = 0;
        int lines = 0;
        String rsMsg = "슬레이브 등록중 오류가 발생했습니다.";
        List<Map<String, Object>> list = map.containsKey("list") ? (List<Map<String, Object>>) map.get("list") : Collections.emptyList();
        try {
            map.put("register","Holding");
            head = repository.insertSlaveHeader(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("seq", i + 1);
                int line = repository.insertSlaveLine(list.get(i));
                lines += line;
                if (line < 1) throw new RuntimeException();
            }
            if (head < 1) throw new RuntimeException();
        } catch (CustomException e) {
            res.fail(e);
            throw new RuntimeException();
        }
//        if( head > 0 && lines > 0 )
        rsMsg = "슬레이브가 등록 됐습니다.";
        return res.success(rsMsg);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateSlave(Map<String, Object> map) {

        int delSeqResult = 0;
        int head = 0;
        int lines = 0;
        String rsMsg = "슬레이브 수정중 오류가 발생했습니다.";
        List<Map<String, Object>> list = map.containsKey("list") ? (List<Map<String, Object>>) map.get("list") : Collections.emptyList();
        String slaveId = String.valueOf(map.get("slaveId"));
        try {
            delSeqResult = repository.deleteSlaveSeq(map);
            if (delSeqResult < 1) throw new RuntimeException();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("seq", i + 1);
                list.get(i).put("slaveId", slaveId);
                int line = repository.updateSlaveLine(list.get(i));
                lines += line;
                if (line < 1) {
                    throw new RuntimeException();
                }
            }

            head = repository.updateSlaveHead(map);
            if (head < 1) {
                throw new RuntimeException();
            }
        } catch (CustomException e) {
            res.fail(e);
            throw new RuntimeException();
        }
//        if( head > 0 && lines > 0 )
        rsMsg = "슬레이브가 수정 됐습니다.";
        return res.success(rsMsg);
    }

    @Override
    public ResponseEntity<?> retrieveSlaveTp() {
        return res.success("retrieveSlaveTp", repository.retrieveSlaveTp());
    }
}
