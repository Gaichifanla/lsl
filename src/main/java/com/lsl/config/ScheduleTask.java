package com.lsl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
public class ScheduleTask {
    @Resource
    WebSocketServer webSocketServer;
    @Scheduled(cron = "0/15 * * * * ?")
    private void personalTask(){

    }
}
