package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052030010Spec;
import com.swontech.s05.service.domain.spec.s052.S052030100Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052030100")
public class S052030100Controller {

    private final S052030100Spec spec;

    public S052030100Controller(S052030100Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "에너지 모니터링 생산계획 조회")
    @GetMapping("/productionPlan")
    public ResponseEntity<?> getProductionPlan(@RequestParam Map<String, Object> map) {
        return spec.getProductionPlan(map);
    }

    @Operation(summary = "에너지 모니터링 생산계획 기존 데이터 삭제 후/새로운 데이터 추가")
    @PostMapping("/delSaveProductionPlan")
    public ResponseEntity<?> delSaveProductionPlan(@RequestBody List<Map<String, Object>> list) {
        return spec.delSaveProductionPlan(list);
    }

}
