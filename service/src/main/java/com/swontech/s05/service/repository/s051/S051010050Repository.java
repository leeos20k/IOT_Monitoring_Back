package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051010050Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S051010050Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetMasterList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010050.selectGetMasterList", map);
    }

    public int deleteMaster(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010050.deleteMaster", map);
    }

    public int deleteSw(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010050.deleteSw", map);
    }

}
