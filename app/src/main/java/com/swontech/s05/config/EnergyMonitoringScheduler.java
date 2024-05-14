package com.swontech.s05.config;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnergyMonitoringScheduler {

    private static int orgId = 1;
    private final SqlSessionTemplate sqlSessionTemplate;

    public EnergyMonitoringScheduler(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


//    @Scheduled(cron = "0 2,12,22,32,42,52 * * * *")
    public void energyTenInfoSave() {
        System.out.println("aggre011 메서드 시작부분");

        try {
            List<Map<String, Object>> list = sqlSessionTemplate.selectList("EnergyMonitoring.GetEnergyTenInfoVO",orgId);
            System.out.println("aggre011 메서드 조회리스트 : "+list);
            Map<String, Object> insertMap = new HashMap<>();
            for(Map<String, Object> map : list){
                System.out.println("aggre011 메서드 리스트 속 맵 : "+map);
                insertMap.put("pumpEventTm",map.get("pumpEventTm"));
                insertMap.put("slaveId",map.get("slaveId"));
                insertMap.put("seq",map.get("seq"));
                insertMap.put("orgId",map.get("orgId"));
                insertMap.put("rValue",map.get("rValue"));
                insertMap.put("sValue",map.get("sValue"));
                insertMap.put("tValue",map.get("tValue"));
                insertMap.put("lValue",map.get("lValue"));
                try {
                    sqlSessionTemplate.insert("EnergyMonitoring.insertAggre011VO",insertMap);
                    System.out.println("맵데이터:"+map+" 저장완료");
                }catch (Exception e){
                    System.out.println("저장실패 : "+e);
                }
            }
        }catch (Exception e){
            System.out.println("에러발생 : "+e);
        }


    }











//    @Scheduled(cron = "0 5 7 * * *")
    public void energyDayInfoDelSave() {
        System.out.println("aggre011 메서드 시작부분");


        ZonedDateTime nowSeoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));//현재날짜
        ZonedDateTime yesterdaySeoul = nowSeoul.minusDays(1);//어제날짜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//시간 포맷

        String fromTime = yesterdaySeoul.format(formatter)+" 07:00:01";
        String toTime = nowSeoul.format(formatter)+" 07:00:00";
        System.out.println("fromTime  : "+fromTime);
        System.out.println("toTime  : "+toTime);


        Map<String, Object> map = new HashMap<>();
        map.put("orgId",orgId);
        map.put("fromTime",fromTime);
        map.put("toTime",toTime);

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

        }catch(Exception e){
            System.out.println("재조정 에러");
        }
    }





}
