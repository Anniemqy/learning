package com.hiveview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testMVC")
    @ResponseBody
    public Map<String,Object> testMVC(){
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("name","martin");
        return responseMap;
    }
}
