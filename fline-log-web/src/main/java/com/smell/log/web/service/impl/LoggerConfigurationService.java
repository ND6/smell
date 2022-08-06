package com.smell.log.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smell.log.web.mapper.LoggerConfigurationDao;
import com.smell.log.web.model.LoggerConfiguration;
import com.smell.log.web.service.ILoggerConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

/**
 * 日志配置相关服务
 */
@Service
@RequiredArgsConstructor
public class LoggerConfigurationService implements ILoggerConfigurationService {
    final
    LoggerConfigurationDao mapper;

    /**
     * 根据节点名称更新级别
     *
     * @param name            日志节点名称
     * @param configuredLevel 日志打印级别
     */
    @Override
    public void UpdateByName(String name, LogLevel configuredLevel) {
        //构造条件
        QueryWrapper<LoggerConfiguration> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        var dto = mapper.selectOne(
                wrapper
        );
        dto.setConfiguredLevel(configuredLevel);
        mapper.updateById(dto);
    }

    @Override
    public void getList() {

    }

}
