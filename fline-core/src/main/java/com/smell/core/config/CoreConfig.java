package com.smell.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 加载核心注解，提供切面，接口文档标注，异步方法，自定义配置等功能开启
 *
 * @author Lenovo
 */
@RestControllerAdvice
@ConfigurationPropertiesScan
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class CoreConfig {

}

