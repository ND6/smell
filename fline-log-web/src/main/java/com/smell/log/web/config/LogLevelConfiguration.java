package com.smell.log.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 通过spring actuator端点暴露的log level控制器
 * 默认暴露的端点路径为/$context-path/actuator/loggers
 */
@Configuration
@PropertySource("classpath:default_log.properties")
public class LogLevelConfiguration {
}
