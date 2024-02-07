package com.kefu.tcp;

import com.alibaba.fastjson.JSON;
import com.kefu.decode.config.BootStrapConfig;
import com.kefu.tcp.server.ImServer;
import com.kefu.tcp.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootApplication
@EnableCaching
@Slf4j
public class Main {
    //配置文件路径
    static String path = "chat_tcp/src/main/resources/config.yaml";
    public static void main(String[] args)  {
        start(path);
    }
    private static void start(String path) {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(path);
            //输入流转化为配置dto
            BootStrapConfig bootStrapConfig = yaml.loadAs(inputStream, BootStrapConfig.class);

            log.info("bootStrapConfig:{}", JSON.toJSONString(bootStrapConfig));
            //启动imServer和WebsocketServer
            new ImServer(bootStrapConfig.getIm()).start();
            new WebSocketServer(bootStrapConfig.getIm()).start();
        } catch (FileNotFoundException e) {
            log.warn("启动失败",e);
            System.exit(500);
        }
    }
}
