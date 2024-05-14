package com.swontech.s05.service.repository.s054;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S054030010Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S054030010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveMasterList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S054030010.GetMasterListVO", map);
    }
}
