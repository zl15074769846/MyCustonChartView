package com.example.mycustonchartview.widght;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.mycustonchartview.bean.MonthReportJiaoyiBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuliang on 2019/7/24.
 */

@SuppressLint("DrawAllocation")
public class CompoundLineView extends View {
    private static final String TAG = "LineView";
    // 默认边距
    private int Margin = 40;
    // 原点坐标
    private int Xpoint;
    private int Ypoint;
    // X,Y轴的单位长度,即表格中的正方形的宽高
    private int Yscale;
    private int Xscale;
    //是否显示表格
    private boolean isShowGrid = false;
    //是否展示表格为虚线
    private boolean isDottedLine = false;
    // X最左边跟Y左下面的线的颜色
    private int XYColor = Color.WHITE;
    // X轴字体的颜色
    private int XTextColor = Color.WHITE;
    // Y轴字体的颜色
    private int YTextColor = Color.WHITE;
    // 表格字体的颜色
    private int GridColor = Color.BLUE;
    // 数据字体的颜色
    private int DataColor = Color.BLUE;
    private int XTextSize = 12;
    private int YTextSize = 12;
    private int marginLeft = 0;
    private int marginBottom = 0;
    private Resources r = Resources.getSystem();
    // X轴上面的显示文字
    private ArrayList<String> XLabel = new ArrayList<>();
    // Y轴上面的显示文字
    private ArrayList<String> YLabel = new ArrayList<>();
    // 曲线数据
    private ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
    private ArrayList<Integer> dataColorList;
    // 单前数据
    private ArrayList<Integer> dataList;
    private int color;
    private int viewWidth;
    private int defXCount = 10;
    private int dataCount;

    //当前

    public CompoundLineView(Context context) {
        super(context);
        initSize();
    }


    public CompoundLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSize();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (null!=dataLists && dataLists.size()>0 && viewWidth > 0) {
            Xscale = (viewWidth - this.Margin * 2) / defXCount * 5 / 2;
            Yscale = Xscale / 3;
            if (dataLists.get(0).size() <= defXCount) {
                dataCount = defXCount;
            } else {
                dataCount = dataLists.get(0).size();
            }
        }

        setMeasuredDimension(Xscale * XLabel.size() + this.Margin * 2 + marginLeft,
                Yscale * YLabel.size() + this.Margin + marginBottom);

    }

    private void initSize() {

        setXTextSize(XTextSize);

        setYTextSize(YTextSize);

        setMarginLeft(marginLeft);

        setMarginBottom(marginBottom);

        this.Margin = setDimensionDIP(Margin);

    }


    // 初始化数据值

    public void init() {

        Xpoint = this.Margin + marginLeft;

        Ypoint = this.getHeight() - this.Margin - marginBottom;


    }


    private Paint transportPaint;
    private Paint darkPaint;
    private Paint whitePaint;
    private int selectIndex = 0;

    @SuppressLint("WrongCall")
    @Override

    protected void onDraw(Canvas canvas) {

        if (null!=dataLists && dataLists.get(0).size() <= defXCount) {
            dataCount = defXCount;
        } else {
            dataCount = dataLists.get(0).size();
        }

        Paint p1 = new Paint();

        p1.setStyle(Paint.Style.STROKE);

        p1.setAntiAlias(true);

        p1.setColor(XYColor);

        p1.setStrokeWidth(4);


        transportPaint = new Paint();
        transportPaint.setColor(Color.parseColor("#70000000"));
        transportPaint.setStyle(Paint.Style.FILL);
        transportPaint.setAntiAlias(true);
        transportPaint.setDither(true);

        darkPaint = new Paint();
        darkPaint.setColor(Color.parseColor("#2d2d2d"));
        darkPaint.setStyle(Paint.Style.STROKE);
        darkPaint.setAntiAlias(true);

        whitePaint = new Paint();
        whitePaint.setColor(Color.parseColor("#ffffff"));
        whitePaint.setStyle(Paint.Style.STROKE);
        whitePaint.setTextSize(27);
        whitePaint.setAntiAlias(true);


        init();

        if (isShowGrid) {

            this.drawTable(canvas);

        } else {

            this.drawXLine(canvas, p1);

            this.drawYLine(canvas, p1);

        }

        if (dataLists != null) {

            for (int i = 0; i < dataLists.size(); i++) {
                this.drawData(canvas, i);
            }

            for (int i = 0; i < XLabel.size(); i++) {
                int startX = Xpoint + i * Xscale;
                //需要放大时使用rectfTouch
                if (i == selectIndex) {
                    if (i == XLabel.size() - 1) {
                        RectF rectF = new RectF(startX + Xscale / 2 - 270, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2
                                , startX + Xscale / 2 - 10, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 160);
                        canvas.drawRect(rectF, transportPaint);
                    } else {
                        RectF rectF = new RectF(startX + Xscale / 2 + 10, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2
                                , startX + Xscale / 2 + 270, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 160);
                        canvas.drawRect(rectF, transportPaint);
                    }

                    canvas.drawLine(startX + Xscale / 2, this.getHeight() - this.Margin - marginBottom,
                            startX + Xscale / 2, -this.Margin - marginBottom + 200, darkPaint);

                    if (i == XLabel.size() - 1) {
                        if (isBiShu) {
                            canvas.drawText("总交易:" + (listCountData.get(i).getTotalSum() + "") + "笔", startX + Xscale / 2 - 240, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 50, whitePaint);
                            canvas.drawText("成功交易:" + (listCountData.get(i).getSuccessSum() + "") + "笔", startX + Xscale / 2 - 240, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 90, whitePaint);
                            canvas.drawText("退款交易:+" + (listCountData.get(i).getRefundSum() + "") + "笔", startX + Xscale / 2 - 240, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 130, whitePaint);
                        } else {
                            canvas.drawText("总交易:+" + (listCountData.get(i).getTotalAmt() + "") + "万元", startX + Xscale / 2 - 240, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 50, whitePaint);
                            canvas.drawText("成功交易:" + (listCountData.get(i).getSuccessAmt() + "") + "万元", startX + Xscale / 2 - 240, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 90, whitePaint);
                            canvas.drawText("退款交易:" + (listCountData.get(i).getRefundAmt() + "") + "万元", startX + Xscale / 2 - 240, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 130, whitePaint);
                        }
                    } else {
                        if (isBiShu) {
                            canvas.drawText("总交易:" + (listCountData.get(i).getTotalSum() + "") + "笔", startX + Xscale / 2 + 20, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 50, whitePaint);
                            canvas.drawText("成功交易:" + (listCountData.get(i).getSuccessSum() + "") + "笔", startX + Xscale / 2 + 20, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 90, whitePaint);
                            canvas.drawText("退款交易:+" + (listCountData.get(i).getRefundSum() + "") + "笔", startX + Xscale / 2 + 20, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 130, whitePaint);
                        } else {
                            canvas.drawText("总交易:+" + (listCountData.get(i).getTotalAmt() + "") + "万元", startX + Xscale / 2 + 20, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 50, whitePaint);
                            canvas.drawText("成功交易:" + (listCountData.get(i).getSuccessAmt() + "") + "万元", startX + Xscale / 2 + 20, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 90, whitePaint);
                            canvas.drawText("退款交易:" + (listCountData.get(i).getRefundAmt() + "") + "万元", startX + Xscale / 2 + 20, this.getHeight() - this.Margin - marginBottom - this.getHeight() / 3 * 2 + 130, whitePaint);
                        }
                    }

                }
            }
        }

    }

    // 画表格

    private void drawTable(Canvas canvas) {

        Paint paint = new Paint();

        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(GridColor);

        Path path = new Path();

        if (isDottedLine) {

            PathEffect effects = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);//画虚线

            paint.setPathEffect(effects);

        }

        int startX = 0;

        int startY = 0;

        int stopX = 0;

        int stopY = 0;

        // 纵向线

        for (int i = 0; i <= dataCount; i++) {

            startX = Xpoint + i * Xscale;

            startY = Ypoint;

            stopY = Ypoint - (this.YLabel.size() - 1) * Yscale;

            if (i != 0) {

                path.moveTo(startX - Xscale / 2, startY);

                path.lineTo(startX - Xscale / 2, stopY);

                canvas.drawPath(path, paint);

            }

            path.moveTo(startX, startY);

            path.lineTo(startX, stopY);

            canvas.drawPath(path, paint);

        }


        // 横向线

        for (int i = 0; i < YLabel.size(); i++) {

            startX = Xpoint;

            startY = Ypoint - i * Yscale;

            stopX = Xpoint + (XLabel.size()) * Xscale;

            path.moveTo(startX, startY);

            path.lineTo(stopX, startY);

            paint.setColor(GridColor);

            canvas.drawPath(path, paint);

        }

        Log.e(TAG, "defXCount :" + defXCount);

    }


    //画纵轴

    private void drawXLine(Canvas canvas, Paint p) {

        p.setColor(XYColor);

        float stopX = Xpoint;

        float stopY = Ypoint - Yscale * (YLabel.size() - 1);

        canvas.drawLine(Xpoint, Ypoint, stopX, stopY, p);

        // Y轴最后是否有箭头

        canvas.drawLine(stopX, stopY, stopX - Xscale / 6, stopY + Yscale / 3, p);

        canvas.drawLine(stopX, stopY, stopX + Xscale / 6, stopY + Yscale / 3, p);

    }


    // 画横轴

    private void drawYLine(Canvas canvas, Paint p) {

        p.setColor(XYColor);

        float stopX = Xpoint + Xscale * dataCount;

        float stopY = Ypoint;

        canvas.drawLine(Xpoint, Ypoint, stopX, stopY, p);

        // X轴最后是否有箭头

        canvas.drawLine(stopX, stopY, stopX - Xscale / 6, stopY - Yscale / 3, p);

        canvas.drawLine(stopX, stopY, stopX - Xscale / 6, stopY + Yscale / 3, p);

    }


    // 画数据

    private void drawData(Canvas canvas, int pos) {

        dataList = dataLists.get(pos);

        color = dataColorList.get(pos);

        Paint p = new Paint();

        p.setAntiAlias(true);

        p.setStrokeWidth(6);

        // 纵轴数据

        for (int i = 0; i < YLabel.size(); i++) {

            int startY = Ypoint - i * Yscale;

//            p.setColor(YTextColor);

            p.setColor(Color.parseColor("#696969"));

            p.setTextSize(XTextSize);

            p.setTextAlign(Paint.Align.RIGHT);

            canvas.drawText(this.YLabel.get(i) + "", this.Margin / 6 * 5 + marginLeft,

                    startY + this.Margin / 5, p);

        }


        //横轴数据

        for (int i = 0; i < dataCount; i++) {

            int startX = Xpoint + i * Xscale;

//            p.setColor(XTextColor);

            p.setColor(Color.parseColor("#696969"));

            p.setTextSize(YTextSize);

            p.setTextAlign(Paint.Align.CENTER);

            String text = "";

            if (i < XLabel.size()) {

                text = this.XLabel.get(i);

            }

            canvas.drawText(text, startX + Xscale / 2,

                    this.getHeight() - this.Margin / 2 - marginBottom, p);

            p.setColor(dataColorList.size() > 0 ? color : DataColor);

            if (i < XLabel.size()) {

                canvas.drawCircle(startX + Xscale / 2, calY(dataList.get(i)), 8, p);


            }

            if (i < XLabel.size() - 1) {

                canvas.drawLine(startX + Xscale / 2, calY(dataList.get(i)),

                        Xpoint + (i + 1) * Xscale + Xscale / 2,

                        calY(dataList.get(i + 1)), p);

            }

        }

    }


    /**
     * 点击X轴坐标或者折线节点
     */
    // 44  142  139
    private void clickAction(MotionEvent event) {
        float eventX = event.getX();
        float startX;
        float befpreX;

        for (int i = 0; i < XLabel.size(); i++) {
            //节点
            startX = Xpoint + (i + 1) * Xscale;

            befpreX = Xpoint + i * Xscale;

            if (befpreX <= eventX && eventX < startX) {
                selectIndex = i;
                invalidate();
                return;
            }

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.getParent().requestDisallowInterceptTouchEvent(false);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                clickAction(event);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    /**
     * dp转化成为px
     *
     * @param dp
     * @return
     */

    private int dpToPx(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f * (dp >= 0 ? 1 : -1));
    }

    /**
     * @param y
     * @return
     */

    private int calY(int y) {

        int y0 = 0;

        int y1 = 0;

        //	Log.i("zzzz", "y:"+y);

        try {

            y0 = Integer.parseInt(YLabel.get(0));

            //		Log.i("zzzz", "y0"+y0);

            y1 = Integer.parseInt(YLabel.get(1));

            //		Log.i("zzzz","y1"+y1);

        } catch (Exception e) {

            //		Log.i("zzzz", "string changed is err");

            return 0;

        }

        try {

            //		Log.i("zzzz", "返回数据"+(Ypoint-(y-y0)*Yscale/(y1-y0)) );

            return Ypoint - ((y - y0) * Yscale / (y1 - y0));

        } catch (Exception e) {

            //	Log.i("zzzz", "return is err");

            return 0;

        }

    }


    public void setXYColor(int XYColor) {

        this.XYColor = XYColor;

    }


    public void setXTextColor(int XTextColor) {

        this.XTextColor = XTextColor;

    }


    public void setYTextColor(int YTextColor) {

        this.YTextColor = YTextColor;

    }


    public void setGridColor(int gridColor) {

        this.GridColor = gridColor;

    }


    public void setDataColor(int dataColor) {

        this.DataColor = dataColor;

    }


    public void setDataColorList(ArrayList<Integer> dataColorList) {

        this.dataColorList = dataColorList;

    }


    public void setXTextSize(int XTextSize) {

        this.XTextSize = setDimensionSP(XTextSize);

    }


    public void setYTextSize(int YTextSize) {

        this.YTextSize = setDimensionSP(YTextSize);

    }


    public void setMarginLeft(int marginLeft) {

        this.marginLeft = setDimensionDIP(marginLeft);

    }


    public void setMarginBottom(int marginBottom) {

        this.marginBottom = setDimensionDIP(marginBottom);

    }


    public void setDefXCount(int defXCount) {

        this.defXCount = defXCount;

    }


    public void setShowGrid(boolean isShowGrid) {

        this.isShowGrid = isShowGrid;

    }


    public void setDottedLine(boolean isDottedLine) {

        this.isDottedLine = isDottedLine;

    }

    private List<MonthReportJiaoyiBean.DataBean> listCountData;

    public void setCountDateList(List<MonthReportJiaoyiBean.DataBean> list) {
        this.listCountData = list;

    }

    public void setXYLabel(ArrayList<String> xlabel, ArrayList<String> ylabel,

                           int viewWidth) {

        this.XLabel = xlabel;

        this.YLabel = ylabel;

        this.viewWidth = viewWidth;


    }


    private boolean isBiShu;

    public void setDataList(ArrayList<ArrayList<Integer>> dataLists, boolean isBiShu) {

        this.dataLists = dataLists;
        this.isBiShu = isBiShu;

        postInvalidate();

    }

    private int setDimensionDIP(int size) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size,

                r.getDisplayMetrics());

    }

    private int setDimensionSP(int size) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size,

                r.getDisplayMetrics());

    }

}
