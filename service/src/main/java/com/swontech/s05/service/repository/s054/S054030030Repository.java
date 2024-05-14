package com.swontech.s05.service.repository.s054;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S054030030Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S054030030Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    public List<Map<String, Object>> getLevelInfo(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S054030030.GetLevelInfoVO", map);
    }

    public Map<String, Object> getYMinMax(Map<String, Object> map) {
        return sqlSessionTemplate.selectOne("S054030030.getYMinMaxVO", map);
    }

    public Map<String, Object> getAlarmLine(Map<String, Object> map) {
        return sqlSessionTemplate.selectOne("S054030030.getAlarmLineVO", map);
    }
}
