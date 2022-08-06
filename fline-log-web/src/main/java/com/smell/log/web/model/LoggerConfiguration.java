package com.smell.log.web.model;

import lombok.Data;
import org.springframework.boot.logging.LogLevel;

/**
 * 表示 LoggingSystem 日志配置的dto类
 *
 */
@Data
public class LoggerConfiguration {

    private int id;

    /**
     * The name of a logger.
     */
    private String name;

    /**
     * 日志配置级别
     */
    private LogLevel configuredLevel;

    /**
     * 有效级别。
     * The effective level is the assigned levelInt and if null, a levelInt is
     * inherited form a parent.
     */
    private LogLevel effectiveLevel;
}
