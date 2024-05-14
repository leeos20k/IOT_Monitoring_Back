package com.swontech.s05.service.controller.s052;


import com.swontech.s05.service.domain.spec.s052.S052030011Spec;
import com.swontech.s05.service.domain.spec.s052.S052030012Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/rest/v1/s052030012")
public class S052030012Controller {

    private final S052030012Spec spec;

    public S052030012Controller(S052030012Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "에너지 생산현황 작업조 select Box VO")
    @GetMapping("/getSelectableGroup")
    public ResponseEntity<?> getSelectableGroup() {
        return spec.getSelectableGroup();
    }

    @Operation(summary = "에너지 모니터링 생산현황 VO")
    @GetMapping("/getEnergyProdListPlan")
    public ResponseEntity<?> getEnergyProdListPlan(@RequestParam Map<String, Object> map) {
        return spec.getEnergyProdListPlan(map);
    }

    @Operation(summary = "에너지 모니터링 생산현황 실적조회 VO")
    @GetMapping("/getEnergyProdListRst")
    public ResponseEntity<?> getEnergyProdListRst(@RequestParam Map<String, Object> map) {
        return spec.getEnergyProdListRst(map);
    }

    @Operation(summary = "에너지 모니터링 생산현황 엑셀 다운로드")
    @GetMapping("/getEnergyProdExcel")
    public ResponseEntity<?> getEnergyProdExcel(@RequestParam Map<String, Object> map) {
        return spec.getEnergyProdExcel(map);
    }


}
