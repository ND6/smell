package com.smell.log.web.controller;

import cn.hutool.core.util.StrUtil;
import com.smell.core.ResponseResult;
import com.smell.log.web.service.ILoggerConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 修改日志级别端点
 */
@RestController
@RequestMapping("/log/level")
@RequiredArgsConstructor
public class LoglevelController {

    /**
     * 日志系统的实例
     */
    final LoggingSystem loggingSystem;

    @Autowired
    ILoggerConfigurationService loggerConfigurationService;

    /**
     * 动态修改LoggerLevel
     *
     * @param name  配置的日志项名称
     * @param level 配置的日志项等级，"TRACE","DEBUG","INFO","WARN","ERROR","OFF"
     * @return
     */
    @PostMapping()
    public ResponseResult<Boolean> updateLoggingLevel(String name, String level) {
        loggingSystem.setLogLevel(name, LogLevel.valueOf(level));
        // 把被修改的日志配置存到数据库
        sync2db(name);
        return ResponseResult.ok(true);
    }

    /**
     * 把日志配置存到数据库
     * @param name  日志节点名称
     */
    private void sync2db(String name) {
        //1 按name 获取新的的日志配置
        var loggerConfiguration= loggingSystem.getLoggerConfiguration(name);
        //2 更新level变化到数据库
        loggerConfigurationService.UpdateByName(loggerConfiguration.getName(),loggerConfiguration.getConfiguredLevel());

    }

    /**
     * 获取系统支持的日志级别
     */
    @GetMapping("/list")
    public ResponseResult<Set<LogLevel>> getLevels() {
        return ResponseResult.ok(loggingSystem.getSupportedLogLevels());
    }

    /**
     * 获取日志显示级别配置
     */
    @GetMapping()
    public ResponseResult<List<LoggerConfiguration>> getLoggers(@RequestParam(required = false) String name) {
        //1.获取系统日志当前配置相关参数集合
        List<LoggerConfiguration> configurations = this.loggingSystem.getLoggerConfigurations();
        if (configurations == null) {
            return ResponseResult.ok(Collections.emptyList());
        }
        //2.过滤指定的日志名称
        if (StrUtil.isNotBlank(name)) {
            configurations = configurations.stream().filter(config -> config.getName().contains(name)).collect(Collectors.toList());
        }

        return ResponseResult.ok(configurations);
    }
}
