package com.swontech.s05.service.domain.logic.s052;

import com.swontech.s05.service.common.CustomException;
import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.domain.spec.s052.S052010070Spec;
import com.swontech.s05.service.repository.s052.S052010070Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class S052010070Logic implements S052010070Spec {
    private final S052010070Repository repository;
    private final CustomResponse res;

    public S052010070Logic(S052010070Repository repository, CustomResponse res) {
        this.repository = repository;
        this.res = res;
    }

    @Override
    public ResponseEntity<?> getUserList(Map<String, Object> map) {
        return res.success("사용자 조회", repository.getUserList(map));
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteUser(ArrayList<Map<String, Object>> array) {
        int delUserResult = 0;
        String result = "사용자 삭제중 오류가 발생했습니다.";
        System.out.println("deleteUser" + array);
        for (Map<String, Object> map : array) {
            System.out.println("delMap:" + map);
            delUserResult = repository.deleteUser(map);
        }
//        if (delUserResult > 0)
        result = "성공적으로 삭제했습니다.";
        return res.success(result);
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveUser(ArrayList<Map<String, Object>> array) {
        int updateUserResult = 0;
        int insertUserResult = 0;
        String result = "사용자 저장중 오류가 발생했습니다.";
        for (Map<String, Object> map : array) {
            if (map.containsKey("userId") || map.get("userId") != null) {
                if (map.get("adminFlag") != null && map.get("adminFlag").equals("")) {
                    map.put("adminFlag", null);
                }
                updateUserResult = repository.updateUser(map);
            } else {
                if (map.get("adminFlag") != null && map.get("adminFlag").equals("")) {
                    map.put("adminFlag", null);
                }
                insertUserResult = repository.insertSlave(map);
            }
        }
//        if (updateUserResult > 0 || insertUserResult > 0)
        result = "성공적으로 저장했습니다.";
        return res.success(result);
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveEMUser(ArrayList<Map<String, Object>> array) {
        int updateUserResult = 0;
        int insertUserResult = 0;
        String result = "사용자 저장중 오류가 발생했습니다.";
        for (Map<String, Object> map : array) {
            if (map.containsKey("userId") || map.get("userId") != null) {
                if (map.get("adminFlag") != null && map.get("adminFlag").equals("")) {
                    map.put("adminFlag", null);
                }
                updateUserResult = repository.updateUser(map);
            } else {
                if (map.get("adminFlag") != null && map.get("adminFlag").equals("")) {
                    map.put("adminFlag", null);
                }
                insertUserResult = repository.InsertEMUser(map);
            }
        }
//        if (updateUserResult > 0 || insertUserResult > 0)
        result = "성공적으로 저장했습니다.";
        return res.success(result);
    }

}
