package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010020Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052010020")
public class S052010020Controller {

    private final S052010020Spec spec;

    public S052010020Controller(S052010020Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Group 조회")
    @GetMapping("/group")
    public ResponseEntity<?> retrieveGroupList(@RequestParam Map<String, Object> map) {
        return spec.retrieveGroupDetail(map);
    }

    @Operation(summary = "Group 등록, 수정")
    @PostMapping("/group")
    public ResponseEntity<?> registerGroup(@RequestBody Map<String, Object> map) {
        return spec.registerGroup(map);
    }

}
