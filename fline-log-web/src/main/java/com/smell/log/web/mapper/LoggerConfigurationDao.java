package com.smell.log.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smell.log.web.model.LoggerConfiguration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoggerConfigurationDao extends BaseMapper<LoggerConfiguration> {
}
