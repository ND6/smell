package com.smell.core;

import lombok.experimental.UtilityClass;

/**
 * 当前操作用户上下文，禁止在业务层使用该对象传参
 */
@UtilityClass
public class UserContext {

    /**
     * 获取当前用户
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getUser(Class<T> tClass) {
        return null;
    }

    /**
     * 设置当前用户
     *
     * @param user
     * @param <T>
     */
    public <T> void putUser(T user) {

    }
}
