package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010070Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010070Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getUserList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010070.GetUserList", map);
    }

    public int deleteUser (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010070.DeleteUser", map);
    }

    public int updateUser(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052010070.UpdateUser", map);
    }

    public int insertSlave(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010070.InsertUser", map);
    }

    public int InsertEMUser(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010070.InsertEMUser", map);
    }
}
