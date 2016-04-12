/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.data.model.exception;

/**
 * @author Kela.King
 */
public class ServerException extends ApiException {

    private ApiError _apiError;

    public ApiError getApiError() {
        return _apiError;
    }

    public ServerException(String detailMessage, Throwable throwable, ApiError apiError) {
        super(detailMessage, throwable);
        _apiError = apiError;
    }
}
