package com.summary.sundy.mvp.component;

import com.summary.sundy.SundyApplication;
import com.summary.sundy.mvp.module.AppModule;
import com.summary.sundy.mvp.module.activity.AllActivitysModule;
import com.summary.sundy.mvp.module.fragment.AllFragmentsModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules ={AndroidInjectionModule.class,AppModule.class,AllActivitysModule.class,AllFragmentsModule.class})
public interface AppComponent {
    void inject(SundyApplication application);
}
