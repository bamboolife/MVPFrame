package com.summary.common.utils;

import android.content.Context;
import android.os.Build;

import java.lang.reflect.Method;

/**
 * Created by abner on 2016/7/24.
 */
public class StatusBarUtils {

    /**
     * 获得状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 收缩状态栏
     * @param context
     */
    public static void collapseStatusBar(Context context) {
        Object sbservice = context.getSystemService("statusbar");
        try {
            Class<?> statusBarManager = Class.forName("android.app.StatusBarManager");
            Method collapse;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                collapse = statusBarManager.getMethod("collapsePanels");
            } else {
                collapse = statusBarManager.getMethod("collapse");
            }
            collapse.invoke(sbservice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 展开状态栏
     * @param context
     */
    public static void expandStatusBar(Context context) {
        Object sbservice = context.getSystemService("statusbar");
        try {
            Class<?> statusBarManager = Class.forName("android.app.StatusBarManager");
            Method expand;
            if (Build.VERSION.SDK_INT >= 17) {
                expand = statusBarManager.getMethod("expandNotificationsPanel");
            } else {
                expand = statusBarManager.getMethod("expand");
            }
            expand.setAccessible(true);
            expand.invoke(sbservice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
