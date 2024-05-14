package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052020010Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052020010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveUser(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052020010.GetUserListVO", map);
    }

}
