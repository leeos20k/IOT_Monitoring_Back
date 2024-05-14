package com.swontech.s05.service.repository.s050;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S050010020Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S050010020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetOrgDetailHead(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S050010020.GetOrgDetailHeadVO", map);
    }

    public List<Map<String, Object>> selectGetOrgDetailLine(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S050010020.GetOrgDetailLineVO", map);
    }

    public int insertOrg(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S050010020.insertOrg", map);
    }

    public void insertApp(Map<String, Object> map) {
        sqlSessionTemplate.insert("S050010020.insertApp", map);
    }

    public int updateOrg(Map<String, Object> map) {
        return sqlSessionTemplate.update("S050010020.updateOrg", map);
    }

    public void deleteApp(Map<String, Object> map) {
        sqlSessionTemplate.delete("S050010020.deleteApp", map);
    }
    public void insertUser(Map<String, Object> map) {
        sqlSessionTemplate.insert("S050010020.insertUser", map);
    }
    public void deleteUser(Map<String, Object> map) {
        sqlSessionTemplate.delete("S050010020.deleteUser", map);
    }

}
