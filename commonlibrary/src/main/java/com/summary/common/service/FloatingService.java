package com.summary.common.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.summary.common.R;
import com.summary.common.utils.StatusBarUtils;

public class FloatingService extends Service {
    private WindowManager windowManager;
    private WindowManager.LayoutParams params;
    private GestureDetector gestureDetector;
    private TextView tv_statusBarView;
    private View view;

    public class SubFloatingService extends Binder {
        public FloatingService getService(){
            return FloatingService.this;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new SubFloatingService();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化悬浮窗
        initFloatingWindow();
    }
    /**
     * 初始化悬浮窗
     */
    private void initFloatingWindow() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        //设置悬浮窗的参数
        params = initParams();
        //加载要悬浮的布局
        view = LayoutInflater.from(this).inflate(R.layout.view_window, null);
        //获取子控件
        tv_statusBarView = (TextView) view.findViewById(R.id.tv_statusBarView);
        //动态将子控件的高度设置成状态栏的高度
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tv_statusBarView.getLayoutParams();
        layoutParams.height = StatusBarUtils.getStatusBarHeight(getApplicationContext());
        tv_statusBarView.setLayoutParams(layoutParams);
        //添加悬浮窗的视图
        windowManager.addView(view, params);

        initEvent();
    }
    /**
     * 设置悬浮窗的参数
     *
     * @return
     */
    private WindowManager.LayoutParams initParams() {
        params = new WindowManager.LayoutParams();
        //设置window type 下面变量2002是在屏幕区域显示，2003则可以显示在状态栏之上
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        //设置图片格式，效果为背景透明
        params.format = PixelFormat.RGBA_8888;
        //设置可以显示在状态栏上,flags值须大于1280时，悬浮窗才会在状态栏之上
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        //设置悬浮窗口长宽数据
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        // 悬浮窗默认显示以左上角为起始坐标
        params.gravity = Gravity.LEFT | Gravity.TOP;
        return params;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      //  Log.i("test","onStartCommand");
        //初始化事件
        initEvent();
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        gestureDetector = new GestureDetector(this, new CustomOnGustureListener());
        tv_statusBarView.setOnTouchListener(new OnFloatingListener());
    }
    //分别用于记录按下，移动、抬起时相应的x、y坐标
    private int startX, startY, moveX, moveY, stopX, stopY;
    private int offsetX, offsetY;
    //用于标记悬浮窗是否有移动
    private boolean isMove;

    /**
     * 由于悬浮窗是位于状态栏之上且覆盖状态栏的焦点以至于状态栏的相应事件失效，如：下拉出通知
     * 因此需要通过监听悬浮窗在不同状态下触发相应的事件
     */
    private class OnFloatingListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    isMove = false;
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    moveX = (int) event.getX();
                    moveY = (int) event.getY();
                    offsetX = Math.abs(startX - moveX);
                    offsetY = Math.abs(startY - moveY);
//                    Log.i("test", "ACTION_MOVE startX==" + startX + " startY==" + startY);
//                    Log.i("test", "ACTION_MOVE moveX==" + moveX + " moveY==" + moveY);
                //    Log.i("test", "ACTION_MOVE offsetX==" + offsetX + " offsetY==" + offsetY);
                    //当移动距离大于某个值时，表示是在下拉状态栏，此时展开状态栏
                    if (Math.abs(offsetY) >= 8) {
                        StatusBarUtils.expandStatusBar(getApplicationContext());
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    offsetX = Math.abs(startX - stopX);
                    offsetY = Math.abs(startY - stopY);
//                    Log.i("test", "ACTION_UP startX==" + startX + " startY==" + startY);
//                    Log.i("test", "ACTION_UP stopX==" + stopX + " stopY==" + stopY);
                 //   Log.i("test", "ACTION_UP offsetX==" + offsetX + " offsetY==" + offsetY);
                    //如果手抬起时移动的距离大于某个值，表示是处于下拉操作
                    if (Math.abs(offsetY) >= 8) {
                        isMove = true;
                    }
                    break;
            }
            return gestureDetector.onTouchEvent(event);//将onTouchEvent交给GestureDetector处理
        }
    }

    /**
     * 自定义手势监听器
     */
    private class CustomOnGustureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            //如果isMove不为true表示是点击事件
            if (!isMove) {
              //  Toast.makeText(getApplicationContext(), "你点击了悬浮窗", Toast.LENGTH_SHORT).show();
            //    Log.i("test", "onClick");
                if(onStatusBarClickListener!=null){
                    onStatusBarClickListener.onClick();
                }
            }
            return super.onSingleTapConfirmed(e);
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
       // Log.i("test","onUnbind");
        //移除悬浮窗
        if (windowManager != null && view != null) {
            windowManager.removeView(view);
            windowManager = null;
            view = null;
        }
        return super.onUnbind(intent);
    }

    private OnStatusBarClickListener onStatusBarClickListener;

    public void setOnStatusBarClickListener(OnStatusBarClickListener onStatusBarClickListener) {
        this.onStatusBarClickListener = onStatusBarClickListener;
    }

    public interface OnStatusBarClickListener{
        void onClick();
    }
}
