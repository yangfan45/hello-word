package com.example.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.RestTemplateService;
import com.example.service.TestService;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AppTestController {

    private final Logger LOGGER = LoggerFactory.getLogger(AppTestController.class);

    private final TestService testService;
    private final RestTemplateService restTemplateService;

    @Autowired
    public AppTestController(TestService testService, RestTemplateService restTemplateService) {
        this.testService = testService;
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/index")
    public String index(){
        LOGGER.info("ssh-app-api index request...");
        return testService.testApp();
    }

    @GetMapping("/getToken")
    public String getToken(){
        LOGGER.info("ssh-app-api getToken request...");
        Pair<Boolean, String> result = restTemplateService.getToken();
        LOGGER.info("ssh-app-api getToken response : {}", JSONObject.toJSONString(result));
        return result.getKey() ? result.getValue() : "获取token失败";
    }
}
