package com.fline.sample.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    protected ApplicationContext applicationContext;


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

    @RequestMapping("/hello")
    public String index() {
        return "Hello World !!! ";
    }
}