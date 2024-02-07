package com.kefu.tcp.server;

import com.kefu.decode.config.BootStrapConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImServer {

    BootStrapConfig.TcpConfig config;
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    ServerBootstrap serverBootstrap;

    public ImServer(BootStrapConfig.TcpConfig config) {
        this.config = config;
        //创建主线程组和工作线程组
        bossGroup = new NioEventLoopGroup(config.getBossThreadSize());
        workerGroup = new NioEventLoopGroup(config.getWorkerThreadSize());
        //创建serverBootStrap
        serverBootstrap = new ServerBootstrap();
        //将线程组加入server
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                //配置channel
                .option(ChannelOption.SO_BACKLOG,10240)//服务端可连接队列大小
                .option(ChannelOption.SO_REUSEADDR,true)//允许重复使用本地地址和端口号
                .childOption(ChannelOption.TCP_NODELAY,true)//禁用NODELAY算法，是否批量发送消息。在这里关闭，因为会影响消息的实时性
                .childOption(ChannelOption.SO_KEEPALIVE,true)//保活开关，2h没有数据发送，服务端回发送心跳包
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });
        log.info("TcpServer启动成功！！！");
    }
    //绑定端口
    public void start(){
        this.serverBootstrap.bind(config.getTcpPort());
    }
}
