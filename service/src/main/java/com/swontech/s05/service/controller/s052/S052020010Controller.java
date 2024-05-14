package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052020010Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052020010")
public class S052020010Controller {

    private final S052020010Spec spec;

    public S052020010Controller(S052020010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Login")
    @PostMapping("/user")
    public ResponseEntity<?> retrieveUser(@RequestBody Map<String, Object> map) {
        return spec.retrieveUser(map);
    }

}
