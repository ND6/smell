package com.fline.sample.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    /**
     * 定时任务打印日志信息 每5s一次
     */
    @Scheduled(fixedRate = 5000)
    public void writeLogs() {
        System.out.println("in writeLog");
        log.info("info!");
        log.debug("debug!!!");
        log.warn("warn!!!");
        log.error("error!!!");
    }
}
