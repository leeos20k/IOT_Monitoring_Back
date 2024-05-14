package com.swontech.s05.service.controller.s050;

import com.swontech.s05.service.domain.spec.s050.S050010010Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s050010010")
public class S050010010Controller {

    private final S050010010Spec spec;

    public S050010010Controller(S050010010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "단체 조회")
    @GetMapping("/org")
    public ResponseEntity<?> retrieveOrgList(@RequestParam Map<String, Object> map) {
        return spec.retrieveOrgList(map);
    }

    @Operation(summary = "단체 삭제")
    @PostMapping("/org-delete")
    public ResponseEntity<?> deleteOrg(@RequestBody List<Integer> list) {
        return spec.deleteOrg(list);
    }

}
