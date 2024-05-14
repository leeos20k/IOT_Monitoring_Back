package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051030050Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s051030050")
public class S051030050Controller {

    private final S051030050Spec spec;

    public S051030050Controller(S051030050Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "User 상세 조회")
    @PostMapping("/switch")
    public ResponseEntity<?> updateSw(@RequestBody Map<String, Object> map) throws Exception {
        return spec.updateSw(map);
    }

    @Operation(summary = "warning")
    @PostMapping("/warning")
    public ResponseEntity<?> warning(@RequestBody String message) throws Exception {
        return spec.warning(message);
    }


}
