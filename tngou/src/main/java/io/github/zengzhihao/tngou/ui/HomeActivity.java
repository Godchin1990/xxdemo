/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.ui;

import android.os.Bundle;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import io.github.zengzhihao.tngou.ui.base.AbstractActivity;
import io.github.zengzhihao.tngou.ui.top.TopActivity;
import io.github.zengzhihao.tngou.util.ToastHelper;

/**
 * @author Kela.King
 */
public class HomeActivity extends AbstractActivity {

    @Inject
    ToastHelper _toastHelper;
    @Inject
    Bus _bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _bus.register(this);
        _toastHelper.show("Hello Tngou!");
        _bus.post(new OnStartTopActivityEvent());
    }

    @Subscribe
    public void onStartTopActivity(OnStartTopActivityEvent event) {
        TopActivity.start(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        _bus.unregister(this);
        super.onDestroy();
    }

    static class OnStartTopActivityEvent {

    }
}
