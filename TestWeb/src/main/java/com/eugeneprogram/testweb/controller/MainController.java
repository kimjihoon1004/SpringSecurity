package com.eugeneprogram.testweb.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
/*import org.apache.catalina.startup.FailedContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Controller;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.eugeneprogram.testweb.service.TestService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MainController {
    @Autowired
    TestService testService;
    
    @GetMapping(value = "/")   
    public String index()   {
        return "home";
    }
    
    @GetMapping(value = "/dbTest.do")
    public ModelAndView dbTest() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("testDbList");
        
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = testService.getList();
        mv.addObject("testDbList", list);
        
        List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
        tempList = testService.getList();
        mv.addObject("tempDbList", tempList);
        
        List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
        allList = testService.getAllList();
        mv.addObject("allList", allList);
        
        return mv;
    }
    
    
    @GetMapping(value = "/selectDB.do", produces = "application/json")
    public List<Map<String, Object>> selectDB() throws Exception{        
        return testService.getAllList();
    }
    
    @GetMapping("/testPage")
    public void getTestPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/test.html");
    }
    
    
}
