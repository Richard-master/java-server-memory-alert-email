package org.example.controller;

import org.example.util.MailUtil;
import org.example.util.MemoryUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Scheduled(fixedRate = 60000) // 每分钟执行一次
    public void myScheduledTask() {
        // 在这里放置你要定时执行的代码
        double memoryUsagePercentage = MemoryUtil.getMemoryUsagePercentage();
        if (memoryUsagePercentage > 92){
            sendEmail(memoryUsagePercentage);
        }
    }

    public void sendEmail(Double memoryUsagePercentage) {
        // 发送邮件的逻辑
        String email = "2890481xxxxxx@qq.com";
        String title = "帕鲁服务器内存预警";
        String text  = "当前内存占用："+memoryUsagePercentage+"%，即将重启服务器";

        MailUtil.sendMail(email, title, text);
    }
}
