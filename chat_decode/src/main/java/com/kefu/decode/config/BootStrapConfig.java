package com.kefu.decode.config;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class BootStrapConfig {
    private TcpConfig im;
    @Data
    public static class TcpConfig{

        private Integer bossThreadSize;
        private Integer workerThreadSize;
        private Integer tcpPort;
        private Integer webSocketPort;
    }

    @Override
    public String toString() {
        return "BootStrapConfig{" +
                "im=" + im +
                '}';
    }

    public static void main(String[] args) {

    }
}
