package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051010050Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s051010050")
public class S051010050Controller {
    private final S051010050Spec spec;

    public S051010050Controller(S051010050Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "마스터 조회")
    @GetMapping("/selectGetMasterList")
    public ResponseEntity<?> selectGetMasterList(@RequestParam Map<String, Object> map) {
        return spec.selectGetMasterList(map);
    }
    @Operation(summary = "마스터 삭제")
    @PostMapping("/deleteMaster")
    public ResponseEntity<?> deleteMaster(@RequestBody Map<String, Object> map) {
        return spec.deleteMaster(map);
    }

}
