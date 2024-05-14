package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051010010Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S051010010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetAreaList(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010010.selectGetAreaList", map);
    }

    public int deleteArea(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010010.deleteArea", map);
    }

}
