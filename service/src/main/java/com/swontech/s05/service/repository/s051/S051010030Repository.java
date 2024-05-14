package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051010030Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S051010030Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveUserList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010030.GetUserListVO", map);
    }

    public int updateAdmin(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010030.UpdateAdmin", map);
    }

    public int endUser(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010030.EndUser", map);
    }

    public int deleteMaster(Map<String, Object> map) {
        return sqlSessionTemplate.delete("S051010030.DeleteMaster", map);
    }

}
