package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051030020Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s051030020")
public class S051030020Controller {
    private final S051030020Spec spec;

    public S051030020Controller(S051030020Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "담당자별 Master 조회")
    @GetMapping("/selectGetUserMasterList")
    public ResponseEntity<?> selectGetUserMasterList(@RequestParam Map<String, Object> map) {
        return spec.selectGetUserMasterList(map);
    }
}
