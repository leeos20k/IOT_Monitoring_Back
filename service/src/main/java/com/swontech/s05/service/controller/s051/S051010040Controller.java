package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051010040Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s051010040")
public class S051010040Controller {

    private final S051010040Spec spec;

    public S051010040Controller(S051010040Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "User조회")
    @GetMapping("/user")
    public ResponseEntity<?> retrieveUser(@RequestParam Map<String, Object> map) {
        return spec.retrieveUser(map);
    }

    @Operation(summary = "User 상세 조회")
    @GetMapping("/user-detail")
    public ResponseEntity<?> retrieveUserDetail(@RequestParam Map<String, Object> map) {
        return spec.retrieveUserDetail(map);
    }

    @Operation(summary = "담당자 등록")
    @PostMapping("/user-insert")
    public ResponseEntity<?> insertUser(@RequestBody Map<String, Object> map) {
        return spec.insertUser(map);
    }

    @Operation(summary = "담당자 수정")
    @PostMapping("/user-update")
    public ResponseEntity<?> updateUser(@RequestBody Map<String, Object> map) {
        return spec.updateUser(map);
    }

}
