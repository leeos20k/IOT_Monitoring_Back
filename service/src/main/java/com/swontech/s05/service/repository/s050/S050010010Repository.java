package com.swontech.s05.service.repository.s050;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S050010010Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S050010010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetOrgList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S050010010.GetOrgListVO", map);
    }

    public int deleteApp(Map<String, Object> map) {
        return sqlSessionTemplate.delete("S050010010.deleteApp", map);
    }

    public int deleteOrg(Map<String, Object> map) {
        return sqlSessionTemplate.delete("S050010010.deleteOrg", map);
    }

}
