package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052030080Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030080Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveSlaveLov(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030080.GetSlaveLovVO", map);
    }

    public List<Map<String, Object>> retrieveSlaveRippleComp1(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030080.GetSlaveRippleCompVO1", map);
    }

    public List<Map<String, Object>> retrieveSlaveRippleComp2(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030080.GetSlaveRippleCompVO2", map);
    }

}
