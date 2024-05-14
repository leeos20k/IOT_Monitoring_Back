package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class S052030013Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030013Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    public List<Map<String, Object>> getSelectableGroup(){
        return sqlSessionTemplate.selectList("S052030013.GetEnergyShiftVO");
    }

    public Map<String, Object> getWaterRate(Map<String, Object> map){
        return sqlSessionTemplate.selectOne("S052030013.GetWaterRateVO",map);
    }

    public int updateWaterRate(List<Map<String, Object>> list){

        int p=0;
        try {
            Map<String, Object> insertMap = new HashMap<>();
            for (Map<String, Object> map : list) {
                insertMap.put("userId", map.get("userId"));
                insertMap.put("waterRate", map.get("waterRate"));
                insertMap.put("orgId", map.get("orgId"));
                insertMap.put("slaveId", map.get("slaveId"));
                insertMap.put("seq", map.get("seq"));
                insertMap.put("fromTime", map.get("fromTime"));
                insertMap.put("toTime", map.get("toTime"));
                sqlSessionTemplate.update("S052030013.UpdateWaterRateVO", map);
            }
            p=1;
        }catch (Exception e){
            System.out.println("업데이트 에러");
        }
        return p;

    }

    public int updateAggre011(Map<String, Object> map){

        int p=0;
        try {
            System.out.println("전날데이터 재저장 메서드 시작부분 map:"+map);
            List<Map<String, Object>> list = sqlSessionTemplate.selectList("EnergyMonitoring.GetEnergyDayInfoVO", map);
            System.out.println("전날데이터 재저장 메서드 조회리스트 : " + list);
            sqlSessionTemplate.delete("EnergyMonitoring.DeleteAggre011VO",map);
            System.out.println("전날데이터 삭제완료");
            Map<String, Object> insertMap = new HashMap<>();
            for (Map<String, Object> listMap : list) {
                insertMap.put("pumpEventTm", listMap.get("pumpEventTm"));
                insertMap.put("slaveId", listMap.get("slaveId"));
                insertMap.put("seq", listMap.get("seq"));
                insertMap.put("orgId", listMap.get("orgId"));
                insertMap.put("rValue", listMap.get("rValue"));
                insertMap.put("sValue", listMap.get("sValue"));
                insertMap.put("tValue", listMap.get("tValue"));
                insertMap.put("lValue", listMap.get("lValue"));
                sqlSessionTemplate.insert("EnergyMonitoring.insertAggre011VO", insertMap);
            }
            System.out.println("전날데이터 재저장완료");
            p=1;
        }catch(Exception e){
            System.out.println("재조정 에러");
        }

        return p;

    }


}
