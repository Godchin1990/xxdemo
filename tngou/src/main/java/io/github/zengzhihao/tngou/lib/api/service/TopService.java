/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.lib.api.service;

import io.github.zengzhihao.tngou.lib.api.model.Top;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author Kela.King
 */
public interface TopService {

    @GET("top/list")
    Observable<Top.Result> list();
}