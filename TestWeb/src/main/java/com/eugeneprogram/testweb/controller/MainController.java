package com.eugeneprogram.testweb.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.apache.catalina.startup.FailedContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Controller;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.eugeneprogram.testweb.service.TestService;

@RestController
public class MainController {
    @Autowired
    TestService testService;
    
    @GetMapping(value = "/")   
    public String index()   {
        return "home";
    }
    
    @GetMapping(value = "/username")
    @ResponseBody
    public ModelAndView currentUserName(Principal principal)  {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("username");
        
        String userNameString = principal.getName();
        
        mv.addObject("userNameString", userNameString);
        return mv;
    }

    @RequestMapping(value = "/main.do") //주소명
    public ModelAndView goMain(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, Principal principal) {
        //
        System.out.println("main.do");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main"); //jsp파일 경로
        
        mv.addObject("userId", userId);
        mv.addObject("userPw", userPw);
        
        String userNameString = principal.getName();
        mv.addObject("usameString", userNameString);
        
        return mv;
    }

    @RequestMapping(value = "/dbTest.do")
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
    
    @RequestMapping(value = "/visa.do")
    public ModelAndView userLogin(Principal principal) throws Exception  {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employee/signup");
        
        String userNameString = principal.getName();
        mv.addObject("userNameString", userNameString);
        
        return mv;
    }
    
    //@RequestMapping 사용 시 'method = RequestMethod.POST'를 이용하여 visa.do에서 넘어오는 값들을 POST방식(=url에 파라미터가 보이지 않음)으로 넘어올 수 있다.
    @RequestMapping(value = "/insertUser.do", method = RequestMethod.POST)
    public String method(String userId, String userName,
            String userPw, String userPhone, String userDate, Principal principal) throws Exception {        
        if(principal.equals(null) || principal == null) {
            System.out.println("---------principal is null-------");            
        }
        else {
            System.out.println("---------" + principal + "---------");
        }
        System.out.println(userName + "\n" + userId + "\n" + userPw + "\n" + userPhone + "\n" + userDate);
        Map<String, Object> userValue = new HashMap<>();        
        userValue.put("userName", userName);
        userValue.put("userId", userId);
        userValue.put("userPw", userPw);
        userValue.put("userPhone", userPhone);
        userValue.put("userDate", userDate);
        int success = testService.insertId(userValue);
        if(success == 0) {
            return fail();
        }
        else {
            return success();
        }             
        
    }
    
    @GetMapping(value = "/success")
    public String success() {
        return "success";
    }
    
    @GetMapping(value = "/fail")
    public String fail()    {
        return "fail";
    }
    
}
