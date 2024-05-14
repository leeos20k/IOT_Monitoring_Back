package com.swontech.s05.service.repository.common;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommonRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public CommonRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getTreeMenu(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("COMMON.GetTreeMenuVO", map);
    }
    public List<Map<String, Object>> getTreeMenuAlarmCnt(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("COMMON.GetTreeMenuAlarmCntVO", map);
    }
    public List<Map<String, Object>> getTreeMenuFixCnt(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("COMMON.GetTreeMenuFixCntVO", map);
    }
    public List<Map<String, Object>> getFootAlarm(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("COMMON.GetFootAlarmVO", map);
    }
    public List<Map<String, Object>> getFootAlarmCnt(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("COMMON.GetFootAlarmCntVO", map);
    }

}
