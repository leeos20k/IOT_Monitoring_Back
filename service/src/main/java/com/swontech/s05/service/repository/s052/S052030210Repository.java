package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052030210Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052030210Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getRegFixMgn(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030210.GetRegFixMgnVO", map);
    }

    public int insertFix010(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052030210.InsertFix010", map);
    }

    public int updateFix010(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052030210.UpdateFix010", map);
    }

    public List<Map<String, Object>> getRegFixBaseTm(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052030210.GetRegFixBaseTmVO", map);
    }
}
