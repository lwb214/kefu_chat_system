package com.kefu.listener;

import com.kefu.util.SshUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.stereotype.Component;

@WebListener
@Component
public class MyContextListener implements ServletContextListener {
        private SshUtil conexionssh;
        public MyContextListener() {
            super();
        }

        @Override
        public void contextInitialized(ServletContextEvent arg0) {
            // 建立连接
            try {
                conexionssh = new SshUtil();
                conexionssh.SSHConnection();
                System.out.println("成功建立SSH连接");
            } catch (Throwable e) {
                System.out.println("SSH连接失败！");
                e.printStackTrace();
            }
        }

        @Override
        public void contextDestroyed(ServletContextEvent arg0) {
            // 断开连接
            System.out.println("Context destroyed ... !\n\n\n");
            try {
                conexionssh.closeSSH(); // disconnect
                System.out.println("\n\n\n成功断开SSH连接!\n\n\n");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\n\n\n断开SSH连接出错！\n\n\n");
            }
        }
}
