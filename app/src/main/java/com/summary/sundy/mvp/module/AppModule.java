package com.summary.sundy.mvp.module;

import com.summary.common.utils.LogUtil;
import com.summary.network.helper.NetHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    static LogUtil provideLogUtil() {
        return new LogUtil();
    }

}
