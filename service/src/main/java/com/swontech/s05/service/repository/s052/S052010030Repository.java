package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010030Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010030Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getMasterList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010030.GetMasterList", map);
    }

    public int deleteSlave (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010030.DeleteSlave", map);
    }

    public int deleteMaster (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010030.DeleteMaster", map);
    }
}
