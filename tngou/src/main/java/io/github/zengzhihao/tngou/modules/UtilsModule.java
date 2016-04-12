/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.zengzhihao.tngou.core.qualifier.ForApplication;
import io.github.zengzhihao.tngou.util.ToastHelper;

/**
 * @author Kela.King
 */
@Module(complete = false, library = true)
public class UtilsModule {

    @Provides
    @Singleton
    ToastHelper provideToastHelper(@ForApplication Context context) {
        return new ToastHelper(context);
    }
}
