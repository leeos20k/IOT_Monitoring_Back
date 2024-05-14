package com.swontech.s05.service.controller.s054;

import com.swontech.s05.service.domain.spec.s052.S052030010Spec;
import com.swontech.s05.service.domain.spec.s054.S054030010Spec;
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
@RequestMapping("/rest/v1/s054030010")
public class S054030010Controller {

    private final S054030010Spec spec;
    public S054030010Controller(S054030010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Master 데이터 조회")
    @GetMapping("/master")
    public ResponseEntity<?> retrieveMasterList(@RequestParam Map<String, Object> map) {
        return spec.retrieveMasterList(map);
    }


}