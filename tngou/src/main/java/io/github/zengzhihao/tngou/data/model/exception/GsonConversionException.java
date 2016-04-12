/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.data.model.exception;

/**
 * @author Kela.King
 */
public class GsonConversionException extends ApiException {

    public GsonConversionException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
