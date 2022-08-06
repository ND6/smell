package com.smell.log.web.controller;

/**
 * 常见常量定义
 *
 * @author Lenovo
 */
public interface Constants {
    //=======================HTTP配置信息=========================
    /**
     * header 中租户ID标识
     */
    String TENANT_ID = "T_ID";
    /**
     * header中的设备编码标识
     */
    String DEVICE_CODE = "D_CODE";
    /**
     * 编码
     */
    String UTF8 = "UTF-8";
    /**
     * 成功标记
     */
    Integer SUCCESS = 0;
    /**
     * 失败标记
     */
    Integer FAIL = 1;
    /**
     * 默认操作
     */
    Integer DEFAULT_OPT = 1;
    /**
     * 网络请求成功值
     */
    Integer NET_SUCCESS = 200;
    /**
     * 网络请求失败值，非200皆可表示失败
     */
    Integer NET_FAIL = 500;


    //=======================格式配置信息=========================
    /**
     * 默认日期格式
     */
    String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
