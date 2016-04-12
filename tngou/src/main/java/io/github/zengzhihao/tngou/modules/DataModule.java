/*
 * Copyright 2015 zengzhihao.github.io. All rights reserved.
 * Support: http://zengzhihao.github.io
 */

package io.github.zengzhihao.tngou.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.zengzhihao.tngou.BuildConfig;
import io.github.zengzhihao.tngou.core.EventBus;
import io.github.zengzhihao.tngou.core.qualifier.ForApplication;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * @author Kela.King
 */
@Module(includes = {ApiModule.class, UtilsModule.class}, complete = false, library = true)
public class DataModule {

    private static final long OKCLIENT_DISK_CACHE_SIZE = 20 * 1024 * 1024;
    private static final String OKCLIENT_DISK_CACHE_NAME = "http-cache";

    private static OkHttpClient _createOkHttpClient(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15000L, TimeUnit.MILLISECONDS)
                .readTimeout(20000L, TimeUnit.MILLISECONDS)
                .writeTimeout(15000L, TimeUnit.MILLISECONDS);

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new StethoInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .cache(new Cache(
                            new File(context.getExternalCacheDir(), OKCLIENT_DISK_CACHE_NAME),
                            OKCLIENT_DISK_CACHE_SIZE));
        } else {
            builder.cache(
                    new Cache(new File(context.getCacheDir(), OKCLIENT_DISK_CACHE_NAME),
                            OKCLIENT_DISK_CACHE_SIZE));
        }
        return builder.build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@ForApplication Context context) {
        return _createOkHttpClient(context);
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(@ForApplication Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Picasso providePicasso(@ForApplication Context context, OkHttpClient okHttpClient) {
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        builder.interceptors().clear();
        builder.addInterceptor(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS));

        Picasso picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(builder.build()))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri,
                                                  Exception exception) {
                        Timber.e(exception, "### Failed to load image: %s", uri);
                    }
                }).build();

        if (BuildConfig.DEBUG) {
            picasso.setIndicatorsEnabled(true);
        }

        return picasso;
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return EventBus.newInstance();
    }
}
