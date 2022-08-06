package com.smell.log.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 表示 LoggingSystem 日志配置的dto类
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class LoggerConfiguration {

    private int id;

    /**
     * The name of a logger.
     */
    private String name;

    /**
     * 日志配置级别
     */
    private String configuredLevel;

    /**
     * 有效级别。
     * The effective level is the assigned levelInt and if null, a levelInt is
     * inherited form a parent.
     */
    private String effectiveLevel;
}
