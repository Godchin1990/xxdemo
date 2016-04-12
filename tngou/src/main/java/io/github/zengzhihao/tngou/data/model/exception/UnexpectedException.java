/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.data.model.exception;

/**
 * @author Kela.King
 */
public class UnexpectedException extends ApiException {

    public UnexpectedException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
