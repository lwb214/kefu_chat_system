package com.kefu.util;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshUtil {
        String user = "root";// 服务器登录名

        String password = "Lwb02141635?";// 登陆密码

        String host = "47.108.95.155";	// 服务器公网IP

        int port = 22;  //ssh通道端口   默认端口 22

        int local_port = 3307; // 这个是本地的端口，选取一个没有占用的port即可

        String remote_host = "127.0.0.1";// 要访问的mysql所在的ip

        int remote_port = 3306;// 服务器上数据库端口号

        Session session = null;
        /**
         *    建立SSH连接
         */
        public void SSHConnection() throws Exception{
            try {
                JSch jsch = new JSch();
                session = jsch.getSession(user, host, port);
                session.setPassword(password);
                session.setConfig("StrictHostKeyChecking", "no");
                session.connect();
                session.setPortForwardingL(local_port, remote_host, remote_port);
            } catch (Exception e) {
                // do something
            }
        }
        /**
         *    断开SSH连接
         */
        public void closeSSH () throws Exception
        {
            this.session.disconnect();
        }
}
