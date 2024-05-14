package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010040Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s052010040")
public class S052010040Controller {
    private final S052010040Spec spec;

    public S052010040Controller(S052010040Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "마스터 상세조회")
    @GetMapping("/getMasterDetail")
    public ResponseEntity<?> getMasterDetail(@RequestParam Map<String, Object> map) {
        return spec.getMasterDetail(map);
    }

    @Operation(summary = "마스터 등록")
    @PostMapping("/insertMaster")
    public ResponseEntity<?> insertMaster(@RequestBody Map<String, Object> map) {
        return spec.insertMaster(map);
    }

    @Operation(summary = "마스터 수정")
    @PostMapping("/updateMaster")
    public ResponseEntity<?> updateMaster(@RequestBody Map<String, Object> map) {
        return spec.updateMaster(map);
    }
}
