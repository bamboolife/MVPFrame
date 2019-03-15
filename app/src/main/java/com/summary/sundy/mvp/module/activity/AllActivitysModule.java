package com.summary.sundy.mvp.module.activity;

import com.summary.sundy.FrameMainLayoutActivity;
import com.summary.sundy.MainActivity;
import com.summary.sundy.mvp.component.activity.BaseActivityComponent;
import com.summary.sundy.ui.activity.AnchorSheetActivity;
import com.summary.sundy.ui.activity.BlurActivity;
import com.summary.sundy.ui.activity.CalendarActivity;
import com.summary.sundy.ui.activity.CoordinatorActivity;
import com.summary.sundy.ui.activity.CustomViewActivity;
import com.summary.sundy.ui.activity.DialogActivity;
import com.summary.sundy.ui.activity.EditTextStyleActivity;
import com.summary.sundy.ui.activity.GuavaActivity;
import com.summary.sundy.ui.activity.InputLayoutActivity;
import com.summary.sundy.ui.activity.NavigationActivity;
import com.summary.sundy.ui.activity.NavigationStyle2Activity;
import com.summary.sundy.ui.activity.NavigationStyleActivity;
import com.summary.sundy.ui.activity.OperatorsActivity;
import com.summary.sundy.ui.activity.PopupWindowActivity;
import com.summary.sundy.ui.activity.ProgressActivity;
import com.summary.sundy.ui.activity.RxBusActivity;
import com.summary.sundy.ui.activity.Segmented2Activity;
import com.summary.sundy.ui.activity.SegmentedActivity;
import com.summary.sundy.ui.activity.SheetViewActivity;
import com.summary.sundy.ui.activity.ShopWidgetActivity;
import com.summary.sundy.ui.activity.SmoothInputActivity;
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

    @ContributesAndroidInjector(modules = NavigationStyle2ActivityModule.class)
    abstract NavigationStyle2Activity contributeNavigationStyle2ActivityInjector();

    @ContributesAndroidInjector(modules = CalendarActivityModule.class)
    abstract CalendarActivity contributeCalendarActivityInjector();

    @ContributesAndroidInjector(modules = ProgressActivityModule.class)
    abstract ProgressActivity contributeProgressActivityInjector();

    @ContributesAndroidInjector(modules = ShopWidgetActivityModule.class)
    abstract ShopWidgetActivity contributeShopWidgetActivityInjector();

    @ContributesAndroidInjector(modules =SegmentedActivityModule.class)
    abstract SegmentedActivity contributeSegmentedActivityInjector();

    @ContributesAndroidInjector(modules =Segmented2ActivityModule.class)
    abstract Segmented2Activity contributeSegmented2ActivityInjector();

    @ContributesAndroidInjector(modules =OperatorsActivityModule.class)
    abstract OperatorsActivity contributeOperatorsActivityInjector();

    @ContributesAndroidInjector(modules =InputLayoutActivityModule.class)
    abstract InputLayoutActivity contributeInputLayoutActivityInjector();

    @ContributesAndroidInjector(modules =SmoothInputActivityModule.class)
    abstract SmoothInputActivity contributeSmoothInputActivityInjector();

    @ContributesAndroidInjector(modules =RxBusActivityModule.class)
    abstract RxBusActivity contributeRxBusActivityInjector();

    @ContributesAndroidInjector(modules =AnchorSheetActivityModule.class)
    abstract AnchorSheetActivity contributeAnchorSheetActivityInjector();

    @ContributesAndroidInjector(modules =GuavaActivityModule.class)
    abstract GuavaActivity contributeGuavaActivityInjector();

    @ContributesAndroidInjector(modules =BlurActivityModule.class)
    abstract BlurActivity contributeBlurActivityInjector();

    @ContributesAndroidInjector(modules =DialogActivityModule.class)
    abstract DialogActivity contributeDialogActivityInjector();

    @ContributesAndroidInjector(modules =SheetViewActivityModule.class)
    abstract SheetViewActivity contributeSheetViewActivityInjector();
}
