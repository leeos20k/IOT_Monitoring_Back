package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052030060Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030060Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveAppMasterLov(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030060.GetAppMasterLovVO", map);
    }

    public List<Map<String, Object>> retrieveAppSlaveList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030060.GetAppSlaveListVO", map);
    }

    public List<Map<String, Object>> retrieveSlaveGraph(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030060.GetSlaveGraphVO", map);
    }

}
