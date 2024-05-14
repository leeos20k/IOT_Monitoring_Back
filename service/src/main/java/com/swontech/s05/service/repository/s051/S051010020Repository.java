package com.swontech.s05.service.repository.s051;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S051010020Repository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S051010020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Map<String, Object>> selectGetAreaDetail(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("S051010020.selectGetAreaDetail", map);
    }

    public Map<String,Object> selectGetAreaSeq(Map<String, Object> map) {
        return sqlSessionTemplate.selectOne("S051010020.selectGetAreaSeq", map);
    }

    public int insertArea(Map<String, Object> map) {
        return sqlSessionTemplate.insert("S051010020.insertArea", map);
    }

    public int deleteArea(Map<String, Object> map) {
        return sqlSessionTemplate.update("S051010020.deleteArea", map);
    }

}
