package com.smell.core.exception;


import com.smell.core.Constants;
import lombok.Data;

/**
 * 业务基本异常，一般用于定义非正常业务流程状态
 *
 * @author Lenovo
 */
@Data
public class FlineBizException extends RuntimeException {

    /**
     * 错误提示编码
     */
    private int code = Constants.FAIL;

    /**
     * @param message 错误提示信息构造方法
     */
    public FlineBizException(String message) {
        super(message);
    }

    /**
     * @param code    错误提示编码
     * @param message 错误提示信息构造方法
     */
    public FlineBizException(int code, String message) {
        this(message);
        this.code = code;
    }
}
