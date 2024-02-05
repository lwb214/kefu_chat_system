package com.kefu.tcp;

import com.alibaba.fastjson.JSON;
import com.kefu.decode.config.BootStrapConfig;
import com.kefu.tcp.server.ImServer;
import com.kefu.tcp.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
@Slf4j
public class Starter {
    static String path = "chat_tcp/src/main/resources/config.yaml";
    public static void main(String[] args)  {
        start(path);
    }
    private static void start(String path) {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(path);
            BootStrapConfig bootStrapConfig = yaml.loadAs(inputStream, BootStrapConfig.class);

            log.info("bootStrapConfig:{}", JSON.toJSONString(bootStrapConfig));

            new ImServer(bootStrapConfig.getIm()).start();
            new WebSocketServer(bootStrapConfig.getIm()).start();
        } catch (FileNotFoundException e) {
            log.warn("启动失败",e);
            System.exit(500);
        }
    }
}
