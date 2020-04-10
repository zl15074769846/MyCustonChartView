package com.example.mycustonchartview.widght;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.mycustonchartview.R;


/**
 * Created by zhuliang on 2019/7/11.
 */

public class HalfCircleProgressView extends View {
    Paint mPaint;
    RectF mRectF;
    //颜色以及宽度
    private int mBackgroudColor;
    private int mProgressColor;
    private float mCircleWidth;
    private int mTextSize;
    private int mTextColor;
    private int mProgress = 0;
    private int mValue = 0;
    private String mName;
    private int mPadding;

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);//绘图为描边模式
        mPaint.setStrokeWidth(17);//画笔宽度
        mPaint.setAntiAlias(true);//抗锯齿
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        //得到画布一半的宽度
        int halfWidth = width / 2;
        int halfHeight = height / 2;
        //定义圆的半径
//        float radius = Math.min(halfWidth, height) - mCircleWidth;
        float radius = halfWidth - mCircleWidth;
//        canvas.translate(halfWidth, height - mPadding);
        canvas.translate(halfWidth, halfWidth);
        //定义一个圆  (float left, float top, float right, float bottom)
        mRectF = new RectF(-radius, -radius, radius, radius);
        mPaint.setColor(Color.parseColor("#58A6FF"));
        canvas.drawArc(mRectF, -200, 220, false, mPaint);
        mPaint.setColor(Color.parseColor("#FFBA00"));
        canvas.drawArc(mRectF, -200, 170, false, mPaint);
        mPaint.setColor(Color.parseColor("#3ECEB6"));
        canvas.drawArc(mRectF, -200, 110, false, mPaint);
        Paint textPaint = new Paint();          // 创建画笔
        textPaint.setColor(mTextColor);        // 设置颜色
        textPaint.setStyle(Paint.Style.FILL);   // 设置样式
        textPaint.setTextSize(mTextSize);
        textPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mName == null ? "XXXXXX" : mName, 0, 2*mPadding, textPaint);
    }

    public HalfCircleProgressView(Context context) {
        this(context, null);
        init();
    }

    public HalfCircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public HalfCircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray at = context.obtainStyledAttributes(attrs, R.styleable.HalfCircleProgressView, defStyleAttr, 0);
        //获取自定义属性和默认值
        //getColor方法的第一个参数是我们在XML文件中定义的颜色，如果我们没有给我们自定义的View定义颜色，他就会使用第二个参数中的默认值
        mBackgroudColor = at.getColor(R.styleable.HalfCircleProgressView_half_circle_backgroudColor, Color.argb(32, 10, 10, 10));
        mProgressColor = at.getColor(R.styleable.HalfCircleProgressView_half_circle_progressColor, Color.BLUE);
        mCircleWidth = at.getDimensionPixelSize(R.styleable.HalfCircleProgressView_half_circle_circleWidth,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
        mTextColor = at.getColor(R.styleable.HalfCircleProgressView_half_circle_textColors, Color.BLACK);
        mTextSize = at.getDimensionPixelSize(R.styleable.HalfCircleProgressView_half_circle_textSizes,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
        mName = at.getString(R.styleable.HalfCircleProgressView_half_circle_name);
        mPadding = at.getDimensionPixelSize(R.styleable.HalfCircleProgressView_half_circle_padding,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
    }

    public void setProgress(int progress) {
        mProgress = progress;
        postInvalidate();
    }

    public void setValue(int value) {
        mValue = value;
        postInvalidate();
    }
}
