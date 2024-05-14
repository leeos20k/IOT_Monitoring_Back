package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052030070Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030070Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveArarmList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030070.GetArarmListVO", map);
    }

    public List<Map<String, Object>> retrieveArarmGraph(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030070.GetArarmGraphVO", map);
    }

    public int deleteAlarm(Map<String, Object> map ){
        return sqlSessionTemplate.delete("S052030070.deleteAlarmVO", map);
    }

}
