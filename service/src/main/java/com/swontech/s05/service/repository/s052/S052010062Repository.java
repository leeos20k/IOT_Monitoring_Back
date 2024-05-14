package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010062Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010062Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }




    public List<Map<String, Object>> getSlaveDetailHead(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010062.GetSlaveDetailHeadVO", map);
    }

    public List<Map<String, Object>> getSlaveDetailLine(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010062.GetSlaveDetailLineVO", map);
    }




    public int insertSlaveHeader(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010062.InsertSlaveHeader", map);
    }


    public int insertSlaveLine(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010062.InsertSlaveLine", map);
    }




    public int deleteSlaveSeq (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010062.DeleteSlaveSeq", map);
    }





    public int updateSlaveLine(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010062.UpdateSlaveLine", map);
    }

    public int updateSlaveHead(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052010062.UpdateSlaveHead", map);
    }







    public List<Map<String, Object>> retrieveSlaveTp() {
        return sqlSessionTemplate.selectList("S052010062.selectSlaveTp");
    }
}
