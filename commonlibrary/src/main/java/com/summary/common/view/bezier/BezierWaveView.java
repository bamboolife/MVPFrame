package com.summary.common.view.bezier;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.summary.common.R;

/**
 * 贝塞尔曲线
 */
public class BezierWaveView extends View {
    //路径和画笔
    private Path mPath;
    private Paint mPaint;
    //波浪的高度
    private int waveHeight;
    public BezierWaveView(Context context) {
        super(context);
        init(null, 0);
    }

    public BezierWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public BezierWaveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.BezierWaveView, defStyle, 0);
         waveHeight=a.getDimensionPixelOffset(R.styleable.BezierWaveView_bwvWaveHeight,100);
//        mExampleString = a.getString(
//                R.styleable.BezierWaveView_bwvString);
//        mExampleColor = a.getColor(
//                R.styleable.BezierWaveView_bwvColor,
//                mExampleColor);
//        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
//        // values that should fall on pixel boundaries.
//        mExampleDimension = a.getDimension(
//                R.styleable.BezierWaveView_bwvDimension,
//                mExampleDimension);
//
//        if (a.hasValue(R.styleable.BezierWaveView_bwvDrawable)) {
//            mExampleDrawable = a.getDrawable(
//                    R.styleable.BezierWaveView_bwvDrawable);
//            mExampleDrawable.setCallback(this);
//        }

        a.recycle();

        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //初始化路径
        mPath = new Path();
        //初始化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(8);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      //  mPaint.reset();

        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;
        //贝塞尔曲线  moveTo移动起点(移动下一次操作的起点位置)
        mPath.moveTo(-contentWidth, contentHeight / 2);
        for (int i = 0; i < 2; i++) {//quadTo, cubicTo贝塞尔曲线(分别为二次和三次贝塞尔曲线的方法)
            mPath.quadTo(-contentWidth * 3 / 4 + (contentWidth * i) , contentHeight / 2 - 100, -contentWidth / 2 + (contentWidth * i) , contentHeight / 2);
            mPath.quadTo(-contentWidth / 4 + (contentWidth * i) , contentHeight / 2 + 100, +(contentWidth * i) , contentHeight / 2);
        }
        //空白部分填充  lineTo连接直线(添加上一个点到当前点之间的直线到Path)
        mPath.lineTo(contentWidth, contentHeight);
        mPath.lineTo(0, contentHeight);
        canvas.drawPath(mPath, mPaint);
    }


}
