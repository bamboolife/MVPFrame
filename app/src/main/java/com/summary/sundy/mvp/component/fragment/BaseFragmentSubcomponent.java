package com.summary.sundy.mvp.component.fragment;

import com.summary.common.base.BaseFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseFragmentSubcomponent extends AndroidInjector<BaseFragment>{
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<BaseFragment>{

    }
}
