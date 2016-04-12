/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou;

import android.content.Context;

import com.facebook.stetho.Stetho;

import dagger.ObjectGraph;
import io.github.zengzhihao.tngou.core.library.Injector;
import io.github.zengzhihao.tngou.modules.Modules;
import timber.log.Timber;

/**
 * @author Kela.King
 */
public class Application extends android.app.Application implements Injector {

    private ObjectGraph _objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        _buildObjectGraph();
        _setupAnalytics();
    }

    private void _setupAnalytics() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                            .build());
        }
    }

    private void _buildObjectGraph() {
        _objectGraph = ObjectGraph.create(Modules.list(this));
    }

    @Override
    public <T> T inject(T t) {
        return _objectGraph.inject(t);
    }

    public static Application getApplicationContext(Context context) {
        return (Application) context.getApplicationContext();
    }
}
