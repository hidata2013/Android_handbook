package com.demo.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    Paint mPaint;
    Path mPath;
    RectF mRect;
    Rect mRangeRect;
    Paint mTextPaint;
    Bitmap mBitmap;
    Xfermode mode;
    Paint mMixPaint;
    Shader mShader;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.q11);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(4.0f);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
        mPath = new Path();
        mPath.reset();
        mRect = new RectF();
        mRangeRect = new Rect(50, 60, 150, 160);
        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(40.0f);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        mMixPaint = new Paint();
        mMixPaint.setTextSize(40.0f);
        mMixPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mMixPaint.setStrokeWidth(1);
        mMixPaint.setColor(Color.BLUE);
        mMixPaint.setAntiAlias(true);
        mMixPaint.setShader(new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(50, 50);
//        mPath.lineTo(10, 50);
//        mPath.moveTo(10, 50);
        mPath.lineTo(200, 50);
        canvas.drawPath(mPath, mPaint);
        mRect.left = 190;
        mRect.top = 40;
        mRect.right = 210;
        mRect.bottom = 60;
        canvas.drawArc(mRect, 0.0f, 360.0f, true, mPaint);

        canvas.drawRect(mRangeRect, mPaint);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(100.0f);
//        mMixPaint.setXfermode(mode);
        canvas.drawText("hello", 50, 160, mTextPaint);
//        canvas.drawBitmap(mBitmap, 50, 170, mMixPaint);
        canvas.drawText("hello world!", 50, 300, mMixPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        event.getX();
        return super.onTouchEvent(event);
    }
}
