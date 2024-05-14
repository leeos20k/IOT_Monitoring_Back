package com.swontech.s05.service.repository.s052;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S052010040Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S052010040Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> getMasterDetailHead(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010040.GetMasterDetailHead", map);
    }

    public List<Map<String, Object>> getMasterDetailLine(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S052010040.GetMasterDetailLine", map);
    }

    public int insertMaster(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010040.InsertMaster", map);
    }

    public int insertSlave(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010040.InsertSlave", map);
    }

    public int deleteSlave (Map<String, Object> map) {
        return sqlSessionTemplate.delete("S052010040.DeleteSlave", map);
    }

    public int updateSlave(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S052010040.UpdateSlave", map);
    }

    public int updateMaster(Map<String, Object> map) {
        return sqlSessionTemplate.update("S052010040.UpdateMaster", map);
    }
}
