package com.swontech.s05.service.domain.logic.s051;

import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.logic.common.PushNotificationLogic;
import com.swontech.s05.service.domain.logic.common.WebSocket;
import com.swontech.s05.service.domain.spec.s051.S051030050Spec;
import com.swontech.s05.service.repository.s051.S051030050Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class S051030050Logic implements S051030050Spec {

    private final S051030050Repository repository;
    private final CustomResponse response;
    private final WebSocket webSocket;
    private final PushNotificationLogic push;

    public S051030050Logic(S051030050Repository repository, CustomResponse response, WebSocket webSocket, PushNotificationLogic push) {
        this.repository = repository;
        this.response = response;
        this.webSocket = webSocket;
        this.push = push;
    }

    @Override
    public ResponseEntity<?> updateSw(Map<String, Object> map) throws Exception {
        String message = "UpdateSwitch";
        ArrayList<ArrayList<Integer>> list = (ArrayList<ArrayList<Integer>>) map.get("update");
        for (ArrayList<Integer> integers : list) {
            map.put("swNo", integers.get(0));
            map.put("swValue", integers.get(1));
            repository.updateSw(map);
            if (integers.get(1).equals(2) || integers.get(1).equals(3)) {
                List<Map<String, Object>> tokenList = repository.pullSwAbTarget(map);
                for (Map<String, Object> stringObjectMap : tokenList) {
                    if (stringObjectMap.get("pushToken") != null) {
                        String token = String.valueOf(stringObjectMap.get("pushToken"));
                        String msg = "";
                        if (integers.get(1).equals(2)) {
                            msg = "풀 코드 스위치 동작 감지";
                        } else {
                            msg = "풀 코드 스위치 통신 오류";
                        }
                        push.sendPushNotification(token, "", msg);
                    }
                }
            }
        }
        webSocket.onMessage("s051030050");
        return response.success(message);
    }

    @Override
    public ResponseEntity<?> warning(String message) throws Exception {
        webSocket.onMessage(message);
        return response.success(message);
    }

}
