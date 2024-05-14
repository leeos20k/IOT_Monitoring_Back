package com.swontech.s05.service.controller.s052;


import com.swontech.s05.service.domain.spec.s052.S052030012Spec;
import com.swontech.s05.service.domain.spec.s052.S052030013Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/rest/v1/s052030013")
public class S052030013Controller {

    private final S052030013Spec spec;

    public S052030013Controller(S052030013Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "에너지 생산현황 수분율조정 select Box VO")
    @GetMapping("/getSelectableGroup")
    public ResponseEntity<?> getSelectableGroup() {
        return spec.getSelectableGroup();
    }

    @Operation(summary = "slave020 수분율 값 불러오기")
    @GetMapping("/getWaterRate")
    public ResponseEntity<?> getWaterRate(@RequestParam Map<String, Object> map) {
        return spec.getWaterRate(map);
    }

    @Operation(summary = "pump010에 수분율 update 처리")
    @PostMapping("/updateWaterRate")
    public ResponseEntity<?> updateWaterRate(@RequestBody List<Map<String, Object>> list) {
        return spec.updateWaterRate(list);
    }

    @Operation(summary = "update한 pump010의 값으로 aggre011 값 업데이트")
    @PostMapping("/updateAggre011")
    public ResponseEntity<?> updateAggre011(@RequestBody Map<String, Object> map) {
        return spec.updateAggre011(map);
    }


}
