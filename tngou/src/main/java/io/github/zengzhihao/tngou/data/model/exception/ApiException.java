/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.data.model.exception;

/**
 * @author Kela.King
 */
public class ApiException extends RuntimeException {

    public ApiException(Throwable throwable) {
        super(throwable);
    }

    public ApiException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

//    public static ApiException create(RetrofitError retrofitError) {
//        Throwable throwable = retrofitError.getCause();
//
//        switch (retrofitError.getKind().ordinal()) {
//            case 0:
//                return new NetworkException("network error", throwable);
//
//            case 1:
//                return new GsonConversionException("gson convert error", throwable);
//
//            case 2:
//                try {
//                    ApiError apiError = (ApiError) retrofitError.getBodyAs(ApiError.class);
//
//                    if (apiError != null) {
//                        return new ServerException("server response error: " +
//                                apiError.toString(), throwable, apiError);
//                    } else {
//                        return new UnexpectedException("unexpected error", throwable);
//                    }
//                } catch (Exception e) {
//                    return new UnexpectedException("unexpected error", throwable);
//                }
//
//            case 3:
//                return new UnexpectedException("unexpected error", throwable);
//
//            default:
//                return new UnexpectedException("unexpected error", throwable);
//        }
//    }
}
