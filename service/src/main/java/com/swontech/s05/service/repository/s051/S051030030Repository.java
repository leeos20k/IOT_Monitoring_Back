package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051030030Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S051030030Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetMasterDetailHead(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051030030.selectGetMasterDetailHead", map);
    }
    public List<Map<String, Object>> selectGetMasterDetailUser(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051030030.selectGetMasterDetailUser", map);
    }
    public List<Map<String, Object>> selectGetMasterDetailSW(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051030030.selectGetMasterDetailSW", map);
    }
}
