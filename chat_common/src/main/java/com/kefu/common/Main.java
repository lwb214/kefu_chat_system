package com.kefu.common;

import com.kefu.common.test.service.Config;
import com.kefu.common.test.service.impl.BoyBuy;
import com.kefu.common.test.service.impl.GirlBuy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            BoyBuy buy = context.getBean(BoyBuy.class);
            GirlBuy girl = context.getBean(GirlBuy.class);

            girl.Play("around info  ");
    }
}