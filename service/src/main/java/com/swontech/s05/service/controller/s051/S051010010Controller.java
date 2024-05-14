package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051010010Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s051010010")
public class S051010010Controller {
    private final S051010010Spec spec;

    public S051010010Controller(S051010010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "구역관리 조회")
        @GetMapping("/selectGetAreaList")
    public ResponseEntity<?> selectGetAreaList(@RequestParam Map<String, Object> map) {
        return spec.selectGetAreaList(map);
    }
    @Operation(summary = "구역 삭제")
    @PostMapping("/deleteArea")
    public ResponseEntity<?> deleteArea(@RequestBody Map<String, Object> map) {
        return spec.deleteArea(map);
    }


}
