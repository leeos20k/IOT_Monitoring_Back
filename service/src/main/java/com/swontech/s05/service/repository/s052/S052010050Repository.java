package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010050Repository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010050Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> retrieveSlaveList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010050.GetSlaveListVO", map);
    }

    public List<Map<String, Object>> retrieveEMSlaveList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010050.GetEMSlaveListVO", map);
    }


    public int deleteSlaveHeader (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010050.deleteSlaveHeader", map);
    }

    public int deleteSlaveSeq (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010050.deleteSlaveSeq", map);
    }

    public int deleteSlave (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010050.deleteSlave", map);
    }

    public List<Map<String, Object>> getMaster020(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010050.getMaster020", map);
    }

}
