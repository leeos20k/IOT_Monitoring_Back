package com.swontech.s05.service.repository.s052;

import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052030062Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030062Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Operation(summary = "에너지센서 분 단위별 집계저장")
    public int CreateEnergyMinCollect() {
        return sqlSessionTemplate.insert("S052030062.CreateEnergyMinCollectVO");
    }

    @Operation(summary = "에너지센서 시 단위별 집계저장")
    public int CreateEnergyHourCollect() {
        return sqlSessionTemplate.insert("S052030062.CreateEnergyHourCollectVO");
    }

    @Operation(summary = "에너지센서 일 단위별 집계저장")
    public int CreateEnergyDayCollect() {
        return sqlSessionTemplate.insert("S052030062.CreateEnergyDayCollectVO");
    }

    @Operation(summary = "1개월전 초단위 실적 데이터 삭제")
    public int DeletePump010 (){
        return sqlSessionTemplate.delete("S052030062.DeletePump010VO");
    }

    @Operation(summary = "1개월전 고장현황 데이터 삭제")
    public int DeleteSlave030 (){
        return sqlSessionTemplate.delete("S052030062.DeleteSlave030");
    }

}
