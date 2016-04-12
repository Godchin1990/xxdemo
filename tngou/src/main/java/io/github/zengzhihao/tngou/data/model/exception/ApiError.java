/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.data.model.exception;

/**
 * @author Kela.King
 */
public class ApiError {

    private Long _code = -1L;
    private String _msg;

    public Long getCode() {
        return _code;
    }

    public String getMsg() {
        return _msg;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "_code=" + _code +
                ", _msg='" + _msg + '\'' +
                '}';
    }
}
