package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010010Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052010010")
public class S052010010Controller {

    private final S052010010Spec spec;

    public S052010010Controller(S052010010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Group 조회")
    @GetMapping("/group")
    public ResponseEntity<?> retrieveGroupList(@RequestParam Map<String, Object> map) {
        return spec.retrieveGroupList(map);
    }

    @Operation(summary = "Group 삭제")
    @PostMapping("/group")
    public ResponseEntity<?> deleteSlave(@RequestBody Map<String, Object> map) {
        return spec.deleteGroup(map);
    }

}
