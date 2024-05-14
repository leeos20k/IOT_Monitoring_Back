package com.swontech.s05.service.controller.s052;

import com.swontech.s05.service.domain.spec.s052.S052030010Spec;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/v1/s052030010")
public class S052030010Controller {

    private final S052030010Spec spec;

    public S052030010Controller(S052030010Spec spec) {
        this.spec = spec;
    }

    @Operation(summary = "Master 목록 조회")
    @GetMapping("/master")
    public ResponseEntity<?> retrieveMasterList(@RequestParam Map<String, Object> map) {
        return spec.retrieveMasterList(map);
    }

    @Operation(summary = "특정 slave-seq, 특정 시간(기준-1시간 ~ 기준시간)의 rstl 값 조회, 알람값 없음")
    @GetMapping("/slaveData")
    public ResponseEntity<?> retrieveSlaveDataList(@RequestParam Map<String, Object> map) {
        return spec.retrieveSlaveDataList(map);
    }

    @Operation(summary = "상단 slave명 조회. slave 그룹의 이름")
    @GetMapping("/slaveGroupName")
    public ResponseEntity<?> retrieveSlaveGroupName(@RequestParam Map<String, Object> map){
        return spec.retrieveSlaveGroupName(map);
    }


    @Operation(summary = "특정 slave-seq, 특정 시간(기준-1시간 ~ 기준시간)의 최대최소 범위지정")
    @GetMapping("/slaveMnMx")
    public ResponseEntity<?> retrieveSlaveMnMx(@RequestParam Map<String, Object> map){
        return spec.retrieveSlaveMnMx(map);
    }


    @Operation(summary = "Slave 이미지 조회")
    @GetMapping("/image")
    public ResponseEntity<?> retrieveImage(@RequestParam Map<String, Object> map) {
        return spec.retrieveImage(map);
    }



    @Operation(summary = "SLAVE_순번정보(tb_s050_slave020) 테이블에 경고 알림 'N' 으로 update")
    @GetMapping("/updateAlarm020")
    public ResponseEntity<?> updateAlarm020(@RequestParam Map<String, Object> map) {return spec.updateAlarm020(map);}

    @Operation(summary = "Slave경고알람정보(tb_s050_slave030) 테이블에 경고 알림 'N' 으로 update")
    @GetMapping("/updateAlarm030")
    public ResponseEntity<?> updateAlarm030(@RequestParam Map<String, Object> map) {return spec.updateAlarm030(map);}





    @Operation(summary = "csv read test")
    @GetMapping("/csv")
    public ResponseEntity<?> csvReadTest(@RequestParam Map<String, Object> map) {
        return spec.csvReadTest(map);
    }

//    @Operation(summary = "대용량api테스트")
//    @GetMapping("/many")
//    public ResponseEntity<?> manyDataTest(@RequestParam Map<String, Object> map) {
//        return spec.manyDataTest(map);
//    }



}
