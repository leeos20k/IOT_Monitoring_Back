package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052020020Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s052020020")
public class S052020020Controller {
    private final S052020020Spec spec;

    public S052020020Controller(S052020020Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "레벨 진행 추이도 조회")
    @GetMapping("/getLevelInfo")
    public ResponseEntity<?> getLevelInfo(@RequestParam Map<String, Object> map) {
        return spec.getLevelInfo(map);
    }

}
