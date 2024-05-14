package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051010060Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s051010060")
public class S051010060Controller {
    private final S051010060Spec spec;

    public S051010060Controller(S051010060Spec spec) {
        this.spec = spec;
    }


    @Operation(summary = "마스터 상세조회")
    @GetMapping("/selectGetMasterDetail")
    public ResponseEntity<?> selectGetMasterDetail(@RequestParam Map<String, Object> map) {
        return spec.selectGetMasterDetail(map);
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
