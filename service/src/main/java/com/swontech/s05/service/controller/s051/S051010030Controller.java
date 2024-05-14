package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051010030Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s051010030")
public class S051010030Controller {

    private final S051010030Spec spec;

    public S051010030Controller(S051010030Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Master 조회")
    @GetMapping("/master")
    public ResponseEntity<?> retrieveUserList(@RequestParam Map<String, Object> map) {
        return spec.retrieveUserList(map);
    }

    @Operation(summary = "관리자 지정/해제")
    @PostMapping("/admin-update")
    public ResponseEntity<?> updateAdmin(@RequestBody Map<String, Object> map) {
        return spec.updateAdmin(map);
    }

    @Operation(summary = "담당자 삭제")
    @PostMapping("/user-delete")
    public ResponseEntity<?> endUser(@RequestParam("loginId") int loginId, @RequestBody List<Integer> list) {
        return spec.endUser(loginId, list);
    }

}
