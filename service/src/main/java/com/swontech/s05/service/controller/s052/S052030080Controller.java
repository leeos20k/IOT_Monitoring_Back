package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052030080Spec;
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
@RequestMapping("/rest/v1/s052030080")
public class S052030080Controller {

    private final S052030080Spec spec;

    public S052030080Controller(S052030080Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Slave 별 파형 비교")
    @GetMapping("/slave")
    public ResponseEntity<?> retrieveSlaveLov(@RequestParam Map<String, Object> map) {
        return spec.retrieveSlaveLov(map);
    }

    @Operation(summary = "Slave 별 파형 비교")
    @GetMapping("/slave-ripple")
    public ResponseEntity<?> retrieveSlaveRippleComp(@RequestParam Map<String, Object> map) {
        return spec.retrieveSlaveRippleComp(map);
    }

}
