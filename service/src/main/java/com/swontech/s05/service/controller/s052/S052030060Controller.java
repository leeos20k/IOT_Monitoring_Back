package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052030060Spec;
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
@RequestMapping("/rest/v1/s052030060")
public class S052030060Controller {

    private final S052030060Spec spec;

    public S052030060Controller(S052030060Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Slave 레벨/전류 모바일 모니터링 Master 검색조건 조회")
    @GetMapping("/master")
    public ResponseEntity<?> retrieveAppMasterLov(@RequestParam Map<String, Object> map) {
        return spec.retrieveAppMasterLov(map);
    }

    @Operation(summary = "Slave 레벨/전류 모바일 모니터링 slave 조회")
    @GetMapping("/slave")
    public ResponseEntity<?> retrieveAppSlaveList(@RequestParam Map<String, Object> map) {
        return spec.retrieveAppSlaveList(map);
    }

    @Operation(summary = "Slave 레벨/전류 추이도 조회")
    @GetMapping("/graph")
    public ResponseEntity<?> retrieveSlaveGraph(@RequestParam Map<String, Object> map) {
        return spec.retrieveSlaveGraph(map);
    }
}
