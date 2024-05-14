package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051020010Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s051020010")
public class S051020010Controller {

    private final S051020010Spec spec;

    public S051020010Controller(S051020010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<?> retrieveLoginInfo(@RequestBody Map<String, Object> map) {
        return spec.retrieveLoginInfo(map);
    }

}
