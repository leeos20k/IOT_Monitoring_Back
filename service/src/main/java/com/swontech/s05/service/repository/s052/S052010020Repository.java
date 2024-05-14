package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010020Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveGroupDetail(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010020.GetGroupDetailVO", map);
    }

    public Map<String, Object> retrieveAreaSeq(Map<String, Object> map) {
        return sqlSessionTemplate.selectOne("S052010020.GetAreaSeqVO", map);
    }

    public int insertArea(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010020.insertArea", map);
    }

    public int deleteArea(Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010020.deleteArea", map);
    }

}
