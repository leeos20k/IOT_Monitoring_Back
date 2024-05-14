package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051010040Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S051010040Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getUser(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010040.GetUserVO", map);
    }

    public List<Map<String, Object>> getUserDetail(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010040.GetUserDetailVO", map);
    }

    public int insertUser(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S051010040.InsertUser", map);
    }

    public int insertMaster(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S051010040.InsertMaster", map);
    }

    public int updateUser(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010040.UpdateUser", map);
    }

    public int deleteUserMater(Map<String, Object> map) {
        return sqlSessionTemplate.delete("S051010040.DeleteUserMater", map);
    }

}
