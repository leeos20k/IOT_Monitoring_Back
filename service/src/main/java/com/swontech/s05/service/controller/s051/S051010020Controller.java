package com.swontech.s05.service.controller.s051;

import com.swontech.s05.service.domain.spec.s051.S051010020Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s051010020")
public class S051010020Controller {
    private final S051010020Spec spec;

    public S051010020Controller(S051010020Spec spec) {
        this.spec = spec;
    }


    @Operation(summary = "구역관리 상세조회")
    @GetMapping("/selectGetAreaDetail")
    public ResponseEntity<?> selectGetAreaDetail(@RequestParam Map<String, Object> map) {
        return spec.selectGetAreaDetail(map);
    }
    @Operation(summary = "구역 등록")
    @PostMapping("/insertArea")
    public ResponseEntity<?> insertArea(@RequestBody Map<String, Object> map) {
        ArrayList<Integer> masterId = (ArrayList<Integer>) map.get("masterId");
        return spec.insertArea(map,masterId);
    }
    @Operation(summary = "구역 수정")
    @PostMapping("/updateArea")
    public ResponseEntity<?> updateArea(@RequestBody Map<String, Object> map) {
        ArrayList<Integer> masterId = (ArrayList<Integer>) map.get("masterId");
        return spec.updateArea(map,masterId);
    }


}
