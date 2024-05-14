package com.swontech.s05.service.controller.s050;

import com.swontech.s05.service.domain.spec.s050.S050010020Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s050010020")
public class S050010020Controller {

    private final S050010020Spec spec;

    public S050010020Controller(S050010020Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "단체 Head 조회")
    @GetMapping("/org-head")
    public ResponseEntity<?> retrieveOrgDetailHead(@RequestParam Map<String, Object> map) {
        return spec.retrieveOrgDetailHead(map);
    }

    @Operation(summary = "단체 Line 조회")
    @GetMapping("/org-line")
    public ResponseEntity<?> retrieveGetDetailLine(@RequestParam Map<String, Object> map) {
        return spec.retrieveGetDetailLine(map);
    }

    @Operation(summary = "단체 등록")
    @PostMapping("/org-insert")
    public ResponseEntity<?> deleteOrg(@RequestBody Map<String, Object> map) {
        return spec.insertOrg(map);
    }

    @Operation(summary = "단체 수정")
    @PostMapping("/org-update")
    public ResponseEntity<?> updateOrg(@RequestBody Map<String, Object> map) {
        return spec.updateOrg(map);
    }

}
