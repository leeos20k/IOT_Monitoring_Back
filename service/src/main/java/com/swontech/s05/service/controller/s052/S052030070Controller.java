package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052030070Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052030070")
public class S052030070Controller {

    private final S052030070Spec spec;

    public S052030070Controller(S052030070Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Slave 레벨/전류 고장현황 조회")
    @GetMapping("/list")
    public ResponseEntity<?> retrieveArarmList(@RequestParam Map<String, Object> map) {
        return spec.retrieveArarmList(map);
    }

    @Operation(summary = "Slave 레벨/전류 고장현황 조회")
    @GetMapping("/graph")
    public ResponseEntity<?> retrieveArarmGraph(@RequestParam Map<String, Object> map) {
        return spec.retrieveArarmGraph(map);
    }

    @Operation(summary = "고장현황 삭제 처리")
    @PostMapping("/deleteAlarm")
    public ResponseEntity<?> deleteAlarm(@RequestBody List<Map<String, Object>> list){
        return spec.deleteAlarm(list);
    }

}
