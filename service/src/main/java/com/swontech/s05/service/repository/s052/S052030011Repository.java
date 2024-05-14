package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class S052030011Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030011Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> GetEnergyList(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyListVO", map);
    }

    public List<Map<String, Object>> GetEnergyListPL(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyListPL", map);
    }

    public List<Map<String, Object>> GetEnergyListRS(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyListRS", map);
    }

    public List<Map<String, Object>> GetEnergyListRSNV(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyListRSNV", map);
    }

    public List<Map<String, Object>> GetEnergyPlanList(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyPlanListVO", map);
    }

    public List<Map<String, Object>> GetEnergyRstProd(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyRstProdVO", map);
    }

    public List<Map<String, Object>> GetEnergyRstLng(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyRstLngVO", map);
    }

    public List<Map<String, Object>> GetEnergyRstPw(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030011.GetEnergyRstPwVO", map);
    }

    public int updateWaterAmount(List<Map<String, Object>> list) {
        int process=0;
        Map<String, Object> updateMap = new HashMap<>();
        try{
            for(Map<String, Object> map : list){
                updateMap.put("slaveId",map.get("slaveId"));
                updateMap.put("seq",map.get("seq"));
                updateMap.put("waterValue",map.get("waterValue"));
                sqlSessionTemplate.update("S052030011.updateWaterAmountVO", updateMap);
            }
            process=1;
        }catch(Exception e){
            System.out.println(e);
        }
        return process;
    }

    public Map<String, Object> getWorkingGroupInquiry(){
        return sqlSessionTemplate.selectOne("S052030011.workingGroupInquiryVO");
    }

    public int updateAlarmConfirm(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052030011.alarmConfirmUpdateVO", map);
    }

}
