package com.cyu.alipay.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
@EnableAsync  //开启多线程
public class MultiScheduleTask {

    @Async
    @Scheduled(fixedDelay = 1000)
    public void task1() {
        System.out.println("task1任务：" + LocalDateTime.now().toLocalTime() + "\r\n当前线程：" + Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void task2() {
        System.out.println("task2任务：" + LocalDateTime.now().toLocalTime() + "\r\n当前线程：" + Thread.currentThread().getName());
    }

}
