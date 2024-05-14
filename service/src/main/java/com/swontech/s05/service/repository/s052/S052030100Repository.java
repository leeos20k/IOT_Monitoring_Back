package com.swontech.s05.service.repository.s052;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Repository
public class S052030100Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030100Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getProductionPlan(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030100.GetEnergyMonPlanVO", map);
    }

    public int delSaveProductionPlan(List<Map<String, Object>> list) {
        int process=0;
        try{
            Map<String, Object> deleteMap = new HashMap<>();
            deleteMap.put("planYear",list.get(0).get("planYear"));
            deleteMap.put("orgId",list.get(0).get("orgId"));
            sqlSessionTemplate.delete("S052030100.DelProductionPlanVO", deleteMap);

            List<String> monthList = Arrays.asList("janValue", "febValue", "marValue", "aprValue",
                                                   "mayValue", "junValue", "julValue", "augValue",
                                                   "sepValue", "octValue", "novValue", "decValue");
            Map<String, Object> saveMap = new HashMap<>();
            for (int i=0; i<4; i++) {//4번째 행 까지만 수행
                for(int j=0; j<monthList.size(); j++){
                    saveMap.put("planYear", list.get(i).get("planYear")+"-"+String.format("%02d",j+1));//'2024-01' '2024-02' '2024-03' 이렇게 생성
                    saveMap.put("energePlanTp", list.get(i).get("energePlanTp"));
                    saveMap.put("userId", list.get(i).get("userId"));
                    saveMap.put("orgId", list.get(i).get("orgId"));
                    saveMap.put("val", list.get(i).get(monthList.get(j))); // 차례대로 janValue, febValue, marValue ~
                    sqlSessionTemplate.insert("S052030100.AddProductionPlanVO", saveMap);
                }
            }
            process=1;
        }catch(Exception e){
            System.out.println(e);
        }
        return process;
    }
}
