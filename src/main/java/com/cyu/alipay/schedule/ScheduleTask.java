package com.cyu.alipay.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
//@EnableScheduling
public class ScheduleTask {

//    @Scheduled(cron = "0/5 * * * * ?")
    private void task1() {
        System.out.println("执行定时任务:" + LocalDateTime.now());
    }
}
