package com.mysiteforme.admin.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhupan
 * @date 2020-08-15
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseInvoke<T> implements Serializable {

    private Integer code;
    private String message;
    private T result;
    private final static Integer OK = 0;
    private final static String OK_MSG = "SUCCESS";

    /**
     * 构造-成功
     */
    private ResponseInvoke() {
        this.code = OK;
        this.message = OK_MSG;
    }

    /**
     * 构造-有结果
     *
     * @param t t
     */
    private ResponseInvoke(T t) {
        this.code = OK;
        this.message = OK_MSG;
        this.result = t;
    }

    /**
     * 构造
     *
     * @param code code
     */
    private ResponseInvoke(Integer code) {
        this.code = code;
    }

    /**
     * 构造
     *
     * @param code    code
     * @param message message
     */
    private ResponseInvoke(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造
     *
     * @param code    code
     * @param message message
     * @param result  result
     */
    private ResponseInvoke(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    /**
     * 构造
     *
     * @param e       e
     */
    private ResponseInvoke(Exception e) {
        this.code = 500;
        this.message = e.getMessage();
    }

    /**
     * 构造
     *
     * @param e       e
     * @param message message
     */
    private ResponseInvoke(Exception e, String message) {
        this(e);
        this.message = message;
    }


    /**
     * 成功-无数据
     *
     * @return 成功
     */
    public static <T> ResponseInvoke<T> ok() {
        return new ResponseInvoke<>();
    }

    /**
     * 成功-有数据
     *
     * @param t   t
     * @param <T> <T>
     * @return 成功结果
     */
    public static <T> ResponseInvoke<T> ok(T t) {
        return new ResponseInvoke<>(t);
    }

    /**
     * 错误
     *
     * @param e e
     * @return 错误
     */
    public static <T> ResponseInvoke<T> error(Exception e) {
        return new ResponseInvoke<>(e);
    }

}
