/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.zengzhihao.tngou.core.qualifier.ForApplication;
import io.github.zengzhihao.tngou.util.Preconditions;

/**
 * @author Kela.King
 */
@Module(includes = {DataModule.class, UiModule.class}, complete = false, library = true)
public class AppModule {

    private final Context _context;

    public AppModule(Application application) {
        _context = Preconditions.checkNotNull(application, "application context can't be null.");
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return _context;
    }
}
