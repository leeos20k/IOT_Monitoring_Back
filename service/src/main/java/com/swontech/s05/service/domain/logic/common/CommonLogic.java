package com.swontech.s05.service.domain.logic.common;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.common.CommonSpec;
import com.swontech.s05.service.repository.common.CommonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommonLogic implements CommonSpec {

    private final CommonRepository repository;
    private final CustomResponse res;
    public CommonLogic(CommonRepository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getTreeMenu(Map<String, Object> map) {
        List<Map<String, Object>> result = repository.getTreeMenu(map);
        List<Map<String, Object>> alarmcnt = repository.getTreeMenuAlarmCnt(map);
        List<Map<String, Object>> ficCnt = repository.getTreeMenuFixCnt(map);

        for (Map<String, Object> objectMap : result) {
            for (Map<String, Object> cnt : alarmcnt) {
                if (objectMap.get("selfId").equals(cnt.get("selfId"))) {
                    objectMap.put("alarm_cnt", cnt.get("grCnt"));
                }
            }
            for (Map<String, Object> cnt : ficCnt) {
                if (objectMap.get("selfId").equals(cnt.get("selfId"))) {
                    objectMap.put("fix_cnt", cnt.get("grFixCnt"));
                }
            }
        }
        return res.success("getTreeMenu",result);
    }
    @Override
    public ResponseEntity<?> getFootAlarm(Map<String, Object> map) {
        List<Map<String, Object>> result = repository.getFootAlarm(map);
        return res.success("getFootAlarm",result);    }

    @Override
    public ResponseEntity<?> getFootAlarmCnt(Map<String, Object> map) {
        List<Map<String, Object>> result = repository.getFootAlarmCnt(map);
        return res.success("getFootAlarmCnt",result);    }
}
