package com.cyu.alipay.schedule;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

@Configuration
//@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Mapper
    interface CronMapper {
        @Select("select cron from t_cron where id = 1")
        String getCron();
    }

    @Autowired
    private CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //任务内容
                () -> System.out.println("执行动态定时任务:" + LocalDateTime.now().toLocalTime()),
                //设置执行周期
                triggerContext -> {
                    //动态获取表达式
                    String cron = cronMapper.getCron();
                    System.out.println("任务表达式" + cron);
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );


    }

}
