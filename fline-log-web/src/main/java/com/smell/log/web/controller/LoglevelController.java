package com.smell.log.web.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.smell.log.web.service.ILoggerConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 修改日志级别端点
 */
@RestController
@RequestMapping("/log/level")
@RequiredArgsConstructor
@Slf4j
public class LoglevelController {

    /**
     * 日志系统的实例
     */
    final LoggingSystem loggingSystem;

//    final ILoggerConfigurationService loggerConfigurationService;

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
     *
     * @param name 日志节点名称
     */
    private void sync2db(String name) {
        //1 按name 获取新的的日志配置
        var loggerConfiguration = loggingSystem.getLoggerConfiguration(name);
        //2 更新level变化到数据库
//        loggerConfigurationService.UpdateByName(loggerConfiguration.getName(), loggerConfiguration.getConfiguredLevel().name());

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


    @GetMapping("foo")
    public ResponseResult<String> foo() {

        com.smell.log.web.model.LoggerConfiguration a = GetLoggerConfiguration(1);

        return ResponseResult.ok(JSONUtil.toJsonStr(a));
    }

    private com.smell.log.web.model.LoggerConfiguration GetLoggerConfiguration(int i) {
        try {
            var connection = getDataSource().getConnection();
            String sql = "select * from LoggerConfiguration where id = 1";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<com.smell.log.web.model.LoggerConfiguration> list = new ArrayList<com.smell.log.web.model.LoggerConfiguration>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String configuredLevel = resultSet.getString("configuredLevel");
                String effectiveLevel = resultSet.getString("effectiveLevel");
                list.add(new com.smell.log.web.model.LoggerConfiguration(id, name, configuredLevel, effectiveLevel));
            }
            for (var el : list) {
                System.out.println(el);
            }
            connection.close();
            return list.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    final ApplicationContext applicationContext;

    DataSource getDataSource() {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            log.error("获取数据源失败", e);
        }
        return dataSource;
    }
}
