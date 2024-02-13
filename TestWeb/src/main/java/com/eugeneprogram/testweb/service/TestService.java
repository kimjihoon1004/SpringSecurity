package com.eugeneprogram.testweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.testweb.dao.TestMapper;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public List<Map<String, Object>> getList() throws Exception {
        return testMapper.getList();
    }
    
    public int comparePw(String pw, String id) throws Exception  {
        return testMapper.comparePw(pw, id);
    }
    
    public List<Map<String, Object>> getAllList() throws Exception  {
        return testMapper.getAllList();
    }
    
    public int insertId(Map<String, Object> a) throws Exception    {
        int success = 0;
        success = testMapper.insertId(a);        
        return success;
    }
}
