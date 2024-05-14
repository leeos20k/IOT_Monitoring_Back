package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010060Spec;
import com.swontech.s05.service.domain.spec.s052.S052010062Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s052010062")
public class S052010062Controller {
    private final S052010062Spec spec;

    public S052010062Controller(S052010062Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "슬레이브 상세조회")
    @GetMapping("/getSlaveDetail")
    public ResponseEntity<?> getSlaveDetail(@RequestParam Map<String, Object> map) {
        return spec.getSlaveDetail(map);
    }

    @Operation(summary = "슬레이브 등록")
    @PostMapping("/insertSlave")
    public ResponseEntity<?> insertSlave(@RequestBody Map<String, Object> map) {
        return spec.insertSlave(map);
    }

    @Operation(summary = "슬레이브 수정")
    @PostMapping("/updateSlave")
    public ResponseEntity<?> updateSlave(@RequestBody Map<String, Object> map) {
        return spec.updateSlave(map);
    }

    @Operation(summary = "SlaveTp조회")
    @GetMapping("/tp")
    public ResponseEntity<?> retrieveSlaveTp() {
        return spec.retrieveSlaveTp();
    }
}
