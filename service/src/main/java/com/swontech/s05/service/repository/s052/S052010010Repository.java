package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010010Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveGroupList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010010.GetGroupListVO", map);
    }

    public int deleteGroup(Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010010.deleteGroup", map);
    }

}
