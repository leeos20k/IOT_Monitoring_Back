package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051030010Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s051030010")
public class S051030010Controller {

    private final S051030010Spec spec;

    public S051030010Controller(S051030010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "구역별 마스터 모니터링")
    @GetMapping("/master-status")
    public ResponseEntity<?> retrieveAreaMasterStatus(@RequestParam Map<String, Object> map) {
        return spec.retrieveAreaMasterStatus(map);
    }

    @Operation(summary = "구역별 마스터 현황")
    @GetMapping("/master-detail")
    public ResponseEntity<?> retrieveAreaMasterDetail(@RequestParam Map<String, Object> map) {
        return spec.retrieveAreaMasterDetail(map);
    }

}
