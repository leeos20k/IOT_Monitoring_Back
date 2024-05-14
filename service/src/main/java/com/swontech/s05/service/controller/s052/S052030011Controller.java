package com.swontech.s05.service.controller.s052;


import com.swontech.s05.service.domain.spec.s052.S052030011Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/rest/v1/s052030011")
public class S052030011Controller {

    private final S052030011Spec spec;

    public S052030011Controller(S052030011Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "에너지 모니터링 조회 VO")
    @GetMapping("/energyList")
    public ResponseEntity<?> GetEnergyList(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyList(map);
    }

    @Operation(summary = "에너지 모니터링 조회 PL")
    @GetMapping("/energyListPL")
    public ResponseEntity<?> GetEnergyListPL(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyListPL(map);
    }

    @Operation(summary = "에너지 모니터링 조회 RS")
    @GetMapping("/energyListRS")
    public ResponseEntity<?> GetEnergyListRS(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyListRS(map);
    }

    @Operation(summary = "에너지 모니터링 조회 RS의 LNG VOL")
    @GetMapping("/energyListRSNV")
    public ResponseEntity<?> GetEnergyListRSNV(@RequestParam Map<String, Object> map) {
        System.out.println("conrollerrrrrrrrrrrr");
        return spec.GetEnergyListRSNV(map);
    }




    @Operation(summary = "에너지 모니터링 그래프 계획량(목표) 조회 VO")
    @GetMapping("/energyPlanList")
    public ResponseEntity<?> GetEnergyPlanList(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyPlanList(map);
    }

    @Operation(summary = "에너지 모니터링 생산성 그래프에 출력하는 생산성 실적 조회 VO")
    @GetMapping("/energyProdList")
    public ResponseEntity<?> GetEnergyRstProd(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyRstProd(map);
    }

    @Operation(summary = " 에너지 모니터링 연료원단위 그래프에 출력하는 연료원단위 실적 조회 VO")
    @GetMapping("/energyLngList")
    public ResponseEntity<?> GetEnergyRstLng(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyRstLng(map);
    }

    @Operation(summary = "에너지 모니터링 동력원단위 그래프에 출력하는 동력원단위 실적 조회 VO")
    @GetMapping("/energyPwList")
    public ResponseEntity<?> GetEnergyRstPw(@RequestParam Map<String, Object> map) {
        return spec.GetEnergyRstPw(map);
    }

    @Operation(summary = "수분량 update 처리")
    @PostMapping("/updateWaterAmount")
    public ResponseEntity<?> updateWaterAmount(@RequestBody List<Map<String, Object>> list) {
        return spec.updateWaterAmount(list);
    }

    @Operation(summary = "근무조 조회")
    @GetMapping("/workingGroup")
    public ResponseEntity<?> getWorkingGroupInquiry() {
        return spec.getWorkingGroupInquiry();
    }

    @Operation(summary = "알람확인 update 처리")
    @PostMapping("/updateAlarmConfirm")
    public ResponseEntity<?> updateAlarmConfirm(@RequestBody Map<String, Object> map) {
        return spec.updateAlarmConfirm(map);
    }




}
