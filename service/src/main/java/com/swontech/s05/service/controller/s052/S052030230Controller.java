package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052030230Spec;
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
@RequestMapping("/rest/v1/s052030230")
public class S052030230Controller {
    private final S052030230Spec spec;

    public S052030230Controller(S052030230Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "년 가동시간 조회")
    @GetMapping("/getYearOpTm")
    public ResponseEntity<?> getYearOpTm(@RequestParam Map<String, Object> map) {
        return spec.getYearOpTm(map);
    }

    @Operation(summary = "월 가동시간 조회")
    @GetMapping("/getMonthOpTm")
    public ResponseEntity<?> getMonthOpTm(@RequestParam Map<String, Object> map) {
        return spec.getMonthOpTm(map);
    }
}
