package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class S052030012Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030012Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getSelectableGroup(){
        return sqlSessionTemplate.selectList("S052030012.GetEnergyShiftVO");
    }

    public Map<String, Object> getEnergyProdListPlan(Map<String, Object> map){
        return sqlSessionTemplate.selectOne("S052030012.GetEnergyProdListPlanVO", map);

    }

    public Map<String, Object> getEnergyProdListRst(Map<String, Object> map){
        return sqlSessionTemplate.selectOne("S052030012.GetEnergyProdListRstVO", map);
    }

    public List<Map<String, Object>> getEnergyProdExcel(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030012.GetEnergyProdExcelVO", map);
    }

}
