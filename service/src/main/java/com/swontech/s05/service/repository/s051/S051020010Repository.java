package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051020010Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S051020010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveLoginInfo(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051020010.GetLoginInfoVO", map);
    }

    public int updatePushToken(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051020010.updateToken", map);
    }

}
