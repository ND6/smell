package com.smell.log.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smell.log.web.model.LoggerConfiguration;
import com.smell.log.web.service.ILoggerConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 日志配置相关服务
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoggerConfigurationService implements ILoggerConfigurationService {


    /**
     * 根据节点名称更新级别
     *
     * @param name            日志节点名称
     * @param configuredLevel 日志打印级别
     */
    @Override
    public void UpdateByName(String name, String configuredLevel) {
        //构造条件
    }

    @Override
    public void getList() {
    }

}
