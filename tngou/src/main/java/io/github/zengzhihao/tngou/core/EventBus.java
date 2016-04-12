/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.core;

import com.squareup.otto.Bus;

import android.os.Handler;
import android.os.Looper;

/**
 * @author Kela.King
 */
public class EventBus extends Bus {

    private static Bus __BUS;
    private final Handler _mainThread = new Handler(Looper.getMainLooper());

    public static Bus newInstance() {
        if (__BUS == null) {
            __BUS = new EventBus();
        }

        return __BUS;
    }

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            _mainThread.post(new Runnable() {
                @Override
                public void run() {
                    EventBus.super.post(event);
                }
            });
        }
    }
}