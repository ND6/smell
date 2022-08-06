package com.smell.log.web.service;

import org.springframework.boot.logging.LogLevel;

public interface ILoggerConfigurationService {

    void UpdateByName(String name, String configuredLevel);

    void getList();
}
