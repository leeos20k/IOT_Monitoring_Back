package com.swontech.s05.service.repository.s052;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Repository
public class S052030010Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveMasterList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030010.GetMasterListVO", map);
    }

    public List<Map<String, Object>> retrieveSlaveDataList(Map<String, Object> map){
        return sqlSessionTemplate.selectList("S052030010.GetSlaveDataListVO", map);
    }

    public Map<String, Object> retrieveSlaveGroupName(Map<String, Object> map){
        return sqlSessionTemplate.selectOne("S052030010.GetSlaveGroupName", map);
    }


    public Map<String, Object> retrieveSlaveMnMx(Map<String, Object> map){
        return sqlSessionTemplate.selectOne("S052030010.GetSlaveGraphYMinMaxVO", map);
    }

    public Map<String, Object> retrieveImage(Map<String, Object> map) {
        return sqlSessionTemplate.selectOne("S052030010.GetImageVO", map);
    }

    public int updateAlarm020(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052030010.updateAlarm020", map);
    }
    public int updateAlarm030(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052030010.updateAlarm030", map);
    }








    public List<Map<String, Object>> csvReadTest(Map<String, Object> map){ //우선 파라미터 기능만 확인해봄

        List<Map<String, Object>> resultList = new ArrayList<>(); //리턴할 리스트 선언

        try {
            FileReader filereader = new FileReader("C:\\csv\\csvDATA1m.csv");
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();

            String[] header = csvReader.readNext();
            if (header != null) {
                String[] rows;
                while ((rows = csvReader.readNext()) != null) {
                    Map<String, Object> map2 = new HashMap<>();
                    for (int i = 0; i < header.length; i++) {
                        map2.put(header[i], rows[i]);
                    }
                    resultList.add(map2);
                }
            }

            filereader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }



        return resultList;
    }



//        public List<Map<String, Object>> manyDataTest(Map<String, Object> map){
//            return sqlSessionTemplate.selectList("S052030010.manyDataTest", map);
//        }




}
