package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010060Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010060Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getSlaveDetailHead(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010060.GetSlaveDetailHeadVO", map);
    }

    public List<Map<String, Object>> getSlaveDetailLine(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010060.GetSlaveDetailLineVO", map);
    }

    public int insertSlaveHeader(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010060.InsertSlaveHeader", map);
    }


    public int insertSlaveLine(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010060.InsertSlaveLine", map);
    }

    public int deleteSlaveSeq (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010060.DeleteSlaveSeq", map);
    }

    public int updateSlaveLine(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010060.UpdateSlaveLine", map);
    }

    public int updateSlaveHead(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052010060.UpdateSlaveHead", map);
    }

    public List<Map<String, Object>> retrieveSlaveTp() {
        return sqlSessionTemplate.selectList("S052010060.selectSlaveTp");
    }
}
