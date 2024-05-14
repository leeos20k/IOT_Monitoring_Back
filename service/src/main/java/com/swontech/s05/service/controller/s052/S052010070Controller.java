package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010070Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s052010070")
public class S052010070Controller {
    private final S052010070Spec spec;

    public S052010070Controller(S052010070Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "사용자 조회")
    @GetMapping("/getUserList")
    public ResponseEntity<?> getSlaveDetail(@RequestParam Map<String, Object> map) {
        return spec.getUserList(map);
    }

    @Operation(summary = "사용자 삭제")
    @PostMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody ArrayList<Map<String,Object>> array) {
        return spec.deleteUser(array);
    }

    @Operation(summary = "사용자 저장")
    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody ArrayList<Map<String,Object>> array) {
        return spec.saveUser(array);
    }

    @Operation(summary = "에너지모니터링 사용자 저장")
    @PostMapping("/saveEMUser")
    public ResponseEntity<?> saveEMUser(@RequestBody ArrayList<Map<String,Object>> array) {
        return spec.saveEMUser(array);
    }

}
