package com.smell.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T> 返回值参数
 * @author y
 */
@ToString
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseResult<T> implements Serializable {

    /**
     * 返回标记：成功标记=0，失败标记=1
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 消息体业务数据
     */
    private T data;

    /**
     * 本次响应时的系统时间
     */
    private long t = System.currentTimeMillis();

    /**
     * 网络请求成功返回，默认不包含任何业务数据
     * 如果没有业务数据返回可以设置业务值为布尔行
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> ok() {
        return restResult(null, Constants.NET_SUCCESS, null);
    }

    /**
     * 网络请求成功返回，设置返回业务数据
     *
     * @param data 业务数据
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> ok(T data) {
        return restResult(data, Constants.NET_SUCCESS, null);
    }

    /**
     * 网络请求成功返回，设置业务数据和提示消息
     * 不建议使用，提示消息一般和错误返回一起使用
     *
     * @param data 业务数据
     * @param msg  提示消息
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> ok(T data, String msg) {
        return restResult(data, Constants.NET_SUCCESS, msg);
    }

    /**
     * 网络请求失败返回，表示本次请求行为与预期不一致
     * 错误返回最好包含错误提示消息，不建议使用
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> failed() {
        return restResult(null, Constants.NET_FAIL, null);
    }

    /**
     * 网络请求失败返回，表示本次请求行为与预期不一致，错误提示问题
     *
     * @param msg 提示消息
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> failed(String msg) {
        return restResult(null, Constants.NET_FAIL, msg);
    }

    /**
     * 网络请求结果，表示本次网络请求成功或者失败，并设置成功的业务数据或者失败的提示消息
     *
     * @param data 业务数据
     * @param code 本次请求结果编码，200为成功，其他都为失败,默认失败为500
     * @param msg  错误提示消息
     * @param <T>
     * @return
     */
    private static <T> ResponseResult<T> restResult(T data, int code, String msg) {
        return new ResponseResult().setData(data).setCode(code).setMsg(msg);
    }

}
