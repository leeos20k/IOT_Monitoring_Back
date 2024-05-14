package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052010050Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052010050")
public class S052010050Controller {

    private final S052010050Spec spec;

    public S052010050Controller(S052010050Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Slave 조회")
    @GetMapping("/slave")
    public ResponseEntity<?> retrieveSlaveList(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return spec.retrieveSlaveList(map);
    }

    @Operation(summary = "에너지모니터링 Slave 조회")
    @GetMapping("/emSlave")
    public ResponseEntity<?> retrieveEMSlaveList(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return spec.retrieveEMSlaveList(map);
    }

    @Operation(summary = "Slave 삭제")
    @PostMapping("/slave")
    public ResponseEntity<?> deleteSlave(@RequestBody List<Integer> list) {
        return spec.deleteSlave(list);
    }

}
