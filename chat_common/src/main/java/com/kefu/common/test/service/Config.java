package com.kefu.common.test.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = {"com.kefu.common.test"})
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan
public class Config {

}
