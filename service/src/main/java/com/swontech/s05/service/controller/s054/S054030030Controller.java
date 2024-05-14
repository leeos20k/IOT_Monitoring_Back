package com.swontech.s05.service.controller.s054;


import com.swontech.s05.service.domain.spec.s054.S054030010Spec;
import com.swontech.s05.service.domain.spec.s054.S054030030Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s054030030")
public class S054030030Controller {

    private final S054030030Spec spec;
    public S054030030Controller(S054030030Spec spec) {
        this.spec = spec;
    }


    @Operation(summary = "특정 전류 데이터 조회(모달)")
    @GetMapping("/getLevelInfo")
    public ResponseEntity<?> getLevelInfo(@RequestParam Map<String, Object> map) {
        return spec.getLevelInfo(map);
    }

    @Operation(summary = "특정 전류 데이터의 가변 Y축 범위")
    @GetMapping("/getYMinMax")
    public ResponseEntity<?> getYMinMax(@RequestParam Map<String, Object> map) {
        return spec.getYMinMax(map);
    }

    @Operation(summary = "특정 전류 데이터의 알람기준선")
    @GetMapping("/getAlarmLine")
    public ResponseEntity<?> getAlarmLine(@RequestParam Map<String, Object> map) {
        return spec.getAlarmLine(map);
    }
}
