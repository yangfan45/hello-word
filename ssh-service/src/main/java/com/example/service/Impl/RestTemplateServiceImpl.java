package com.example.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.service.RestTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @date 2019/2/2
     * @describe restTemplate GET 请求
     */
    @Override
    public Pair<Boolean, String> getToken() {
        /**
         *  构造请求头
         */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiMCIsInVuaXF1ZV9waG9uZSI6IjE4ODEwOTE2NTAwIiwidXNlcklkIjoiMTYzOSIsImlzcyI6InJlc3RhcGl1c2VyIiwiYXVkIjoiMDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTg2NDI2NGI0ZjgifQ.esko-CJOmrEQ2QCh754okGqxWc_znI9Pakv6KFklUxM");
        /**
         *  发送请求
         */
        String response = restTemplate.exchange(
                "http://139.224.149.243:8180/edriver/getToken",
                HttpMethod.GET,
                new HttpEntity<Object>(null, headers),
                new ParameterizedTypeReference<String>() {
        }).getBody();

        LOGGER.info("RestTemplateServiceImpl getToken request : header : {} , body : {} ; response : {}", JSONObject.toJSONString(headers),null,JSONObject.toJSONString(response));

        return StringUtils.isEmpty(response) ? Pair.of(false,"") : Pair.of(true,response);
    }
}
