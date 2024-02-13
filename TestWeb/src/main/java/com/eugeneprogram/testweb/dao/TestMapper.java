package com.eugeneprogram.testweb.dao;

import java.util.List;
import java.util.Map;

public interface TestMapper {
    public List<Map<String, Object>> getList() throws Exception;
    public int comparePw(String pw, String id) throws Exception;
    public List<Map<String, Object>> getAllList() throws Exception;
    public int insertId(Map<String, Object> a) throws Exception;
}
