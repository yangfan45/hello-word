package com.example.service.Impl;

import com.example.service.*;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    /**
     * @date 2018/9/10
     * @describe
     **/
    @Override
    public String testApp() {
        return "Success to use service";
    }
}
