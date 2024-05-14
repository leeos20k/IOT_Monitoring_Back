package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010030Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s052010030")
public class S052010030Controller {
    private final S052010030Spec spec;

    public S052010030Controller(S052010030Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "마스터 조회")
    @GetMapping("/getMasterList")
    public ResponseEntity<?> getMasterList(@RequestParam Map<String, Object> map) {
        return spec.getMasterList(map);
    }

    @Operation(summary = "마스터 삭제")
    @PostMapping("/deleteMaster")
    public ResponseEntity<?> deleteMaster(@RequestBody ArrayList<String> array) {
        return spec.deleteMaster(array);
    }
}
