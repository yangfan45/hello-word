package com.example.service;

import org.apache.commons.lang3.tuple.Pair;

public interface RestTemplateService {

    /**
     * @date 2019/2/2
     * @describe restTemplate GET 请求
     */
    Pair<Boolean,String> getToken();
}
