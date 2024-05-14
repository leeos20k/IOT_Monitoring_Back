package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051010060Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S051010060Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetMasterDetail(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010060.selectGetMasterDetail", map);
    }

    public int insertMaster(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S051010060.insertMaster", map);
    }

    public int updateMaster(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010060.updateMaster", map);
    }

    public int deleteMaster(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010060.deleteMaster", map);
    }

    public int insertSwitch(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S051010060.insertSwitch", map);
    }





}
