package com.summary.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.summary.common.R;

/**
 * 引导页圆形倒计时跳转
 */
public class CountDownCircleView extends View {

    private int circleBgColor;
    private int circlePbColor;
    private int circlePbWidth;
    private int circleTextColor;
    private int circleTextSize;
    private ValueAnimator valueAnimator;
    private OnCountDownFinishedListener countDownFinishedListener;
    public CountDownCircleView(Context context) {
        this(context,null);
    }

    public CountDownCircleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CountDownCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrWithStyle(context, attrs, defStyleAttr);
        init();
    }

    private void initAttrWithStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CountDownCircleView,defStyleAttr,R.style.def_countdown_circle_view);
        int indexCount=typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.CountDownCircleView_circle_bg_color) {
                circleBgColor = typedArray.getColor(attr, Color.BLACK);

            } else if (attr == R.styleable.CountDownCircleView_circle_pb_color) {
                circlePbColor = typedArray.getColor(attr, Color.BLACK);

            } else if (attr == R.styleable.CountDownCircleView_circle_pb_width) {
                circlePbWidth = typedArray.getDimensionPixelOffset(attr, 0);

            } else if (attr == R.styleable.CountDownCircleView_circle_text_color) {
                circleTextColor = typedArray.getColor(attr, Color.BLACK);

            } else if (attr == R.styleable.CountDownCircleView_circle_text_size) {
                circleTextSize = typedArray.getDimensionPixelSize(attr, 0);

            }
        }
        typedArray.recycle();
    }

    private void init() {
    }

    /**
     * 开始倒计时
     * @param countDownFinishedListener
     */
    public void startCountDown(OnCountDownFinishedListener countDownFinishedListener){

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                if (null!=countDownFinishedListener){
                    countDownFinishedListener.countDownStop();
                    valueAnimator.cancel();
                }
                break;
        }
        return true;
    }

    /**
     * 倒计时完成回调接口
     */
    public interface OnCountDownFinishedListener{
        void countDownStop();
    }
}
