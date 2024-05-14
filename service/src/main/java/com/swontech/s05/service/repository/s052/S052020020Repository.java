package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052020020Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052020020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getSlaveName(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052020020.GetSlaveName", map);
    }

    public List<Map<String, Object>> getLevelValue(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052020020.GetLevelValue", map);
    }
}
