package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051030050Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S051030050Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int updateSw(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051030050.UpdateSw", map);
    }

    public List<Map<String, Object>> pullSwAbTarget(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051030050.PullSwAbTargetVO", map);
    }

}
