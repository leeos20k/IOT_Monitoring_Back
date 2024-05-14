package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051030030Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s051030030")
public class S051030030Controller {
    private final S051030030Spec spec;

    public S051030030Controller(S051030030Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "담당자별 Master 상세조회")
    @GetMapping("/selectGetUserMasterDetail")
    public ResponseEntity<?> selectGetUserMasterDetail(@RequestParam Map<String, Object> map) {
        return spec.selectGetUserMasterDetail(map);
    }
}
