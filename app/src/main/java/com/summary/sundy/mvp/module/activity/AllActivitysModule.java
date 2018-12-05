package com.summary.sundy.mvp.module.activity;

import com.summary.sundy.FrameMainLayoutActivity;
import com.summary.sundy.MainActivity;
import com.summary.sundy.mvp.component.activity.BaseActivityComponent;
import com.summary.sundy.ui.activity.CalendarActivity;
import com.summary.sundy.ui.activity.CoordinatorActivity;
import com.summary.sundy.ui.activity.CustomViewActivity;
import com.summary.sundy.ui.activity.EditTextStyleActivity;
import com.summary.sundy.ui.activity.NavigationActivity;
import com.summary.sundy.ui.activity.NavigationStyleActivity;
import com.summary.sundy.ui.activity.PopupWindowActivity;
import com.summary.sundy.ui.activity.ProgressActivity;
import com.summary.sundy.ui.activity.TitleBarActivity;
import com.summary.sundy.ui.activity.ToastActivity;
import com.summary.sundy.ui.activity.UITabViewActivity;
import com.summary.sundy.ui.activity.WebActivity;
import com.summary.sundy.ui.activity.WeiboPopupWindowActivity;
import com.summary.sundy.ui.activity.XEditTextActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseActivityComponent.class)
public abstract class AllActivitysModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector(modules = EditTextStyleActivityModule.class)
    abstract EditTextStyleActivity contributeEditTextStyleActivityInjector();

    @ContributesAndroidInjector(modules = XEditTextActivityModule.class)
    abstract XEditTextActivity contributeXEditTextActivityInjector();

    @ContributesAndroidInjector(modules = CoordinatorActivityModule.class)
    abstract CoordinatorActivity contributeCoordinatorActivityInjector();

    @ContributesAndroidInjector(modules = TitleBarActivityModule.class)
    abstract TitleBarActivity contributeTitleBarActivityInjector();

    @ContributesAndroidInjector(modules = PopupWindowActivityModule.class)
    abstract PopupWindowActivity contributePopupWindowActivityInjector();

    @ContributesAndroidInjector(modules = WeiboPopupWindowActivityModule.class)
    abstract WeiboPopupWindowActivity contributeWeiboPopupWindowActivityInjector();

    @ContributesAndroidInjector(modules = CustomViewActivityModule.class)
    abstract CustomViewActivity contributeCustomViewActivityInjector();

    @ContributesAndroidInjector(modules = UITabViewActivityModule.class)
    abstract UITabViewActivity contributeUITabViewActivityInjector();

    @ContributesAndroidInjector(modules = ToastActivityModule.class)
    abstract ToastActivity contributeToastActivityInjector();
    @ContributesAndroidInjector(modules = FrameMainLayoutActivityModule.class)
    abstract FrameMainLayoutActivity contributeFrameMainLayoutActivityInjector();

    @ContributesAndroidInjector(modules = WebActivityModule.class)
    abstract WebActivity contributeWebActivityInjector();

    @ContributesAndroidInjector(modules = NavigationActivityModule.class)
    abstract NavigationActivity contributeNavigationActivityInjector();

    @ContributesAndroidInjector(modules = NavigationStyleActivityModule.class)
    abstract NavigationStyleActivity contributeNavigationStyleActivityInjector();

    @ContributesAndroidInjector(modules = CalendarActivityModule.class)
    abstract CalendarActivity contributeCalendarActivityInjector();

    @ContributesAndroidInjector(modules = ProgressActivityModule.class)
    abstract ProgressActivity contributeProgressActivityInjector();
}
