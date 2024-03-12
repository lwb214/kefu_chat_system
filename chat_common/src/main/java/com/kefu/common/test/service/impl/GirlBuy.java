package com.kefu.common.test.service.impl;

import com.kefu.common.test.aspect.LogAnnotation;
import com.kefu.common.test.service.Buy;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class GirlBuy implements Buy {
    @LogAnnotation
    @Override
    public void Play(String info) {
        System.out.println("我是女孩");
    }
}
