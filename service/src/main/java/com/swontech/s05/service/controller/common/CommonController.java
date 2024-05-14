package com.swontech.s05.service.controller.common;

import com.swontech.s05.service.domain.spec.common.CommonSpec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/common")
public class CommonController {

    private final CommonSpec spec;
    public CommonController(CommonSpec spec) {
        this.spec = spec;
    }

    @Operation(summary = "설비 Tree 구조 메뉴 조회")
    @GetMapping("/getTreeMenu")
    public ResponseEntity<?> getTreeMenu(@RequestParam Map<String, Object> map) {
        return spec.getTreeMenu(map);
    }

    @Operation(summary = "하단의 최신의 경고 알람 조회")
    @GetMapping("/getFootAlarm")
    public ResponseEntity<?> getFootAlarm(@RequestParam Map<String, Object> map) {
        return spec.getFootAlarm(map);
    }

    @Operation(summary = "하단의 경고 갯수 조회")
    @GetMapping("/getFootAlarmCnt")
    public ResponseEntity<?> getFootAlarmCnt(@RequestParam Map<String, Object> map) {
        return spec.getFootAlarmCnt(map);
    }
}
