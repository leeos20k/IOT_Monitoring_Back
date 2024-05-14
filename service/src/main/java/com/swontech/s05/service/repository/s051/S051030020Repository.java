package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051030020Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S051030020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetUserMasterList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051030020.selectGetUserMasterList", map);
    }
}
