package com.example.mycustonchartview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.mycustonchartview.bean.DoctorJieZhenBean;
import com.example.mycustonchartview.bean.MonthReportJiaoyiBean;
import com.example.mycustonchartview.bean.MultiGroupHistogramChildData;
import com.example.mycustonchartview.bean.MultiGroupHistogramGroupData;
import com.example.mycustonchartview.widght.ChartView;
import com.example.mycustonchartview.widght.CompoundLineView;
import com.example.mycustonchartview.widght.MultiGroupHistogramView;
import com.example.mycustonchartview.widght.PieChartView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CharViewAtivity extends AppCompatActivity {

    private MultiGroupHistogramView multiGroupHistogramView;
    private ChartView chatLineView;
    private PieChartView pieChartView;
    private CompoundLineView mSkinLineView;
    private LinearLayout mLineLL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.char_view_layout);

        multiGroupHistogramView=findViewById(R.id.multiGroupHistogramView);
        initYuanZhuView();

        chatLineView=findViewById(R.id.chart_qushi_view);
        setJieZhenData();

        pieChartView=findViewById(R.id.percentPieView);
        initPiechart();

        mSkinLineView=findViewById(R.id.skinLineView);
        mLineLL=findViewById(R.id.LineLL);
        initViews();


    }

    private void initYuanZhuView() {
        Random random = new Random();
        int groupSize = random.nextInt(5) + 10;
        List<MultiGroupHistogramGroupData> groupDataList = new ArrayList<>();
        // 生成测试数据
        for (int i = 0; i < groupSize; i++) {
            List<MultiGroupHistogramChildData> childDataList = new ArrayList<>();
            MultiGroupHistogramGroupData groupData = new MultiGroupHistogramGroupData();
            groupData.setGroupName("第" + (i + 1) + "组");
            MultiGroupHistogramChildData childData1 = new MultiGroupHistogramChildData();
            childData1.setSuffix("分");
            childData1.setValue(random.nextInt(50) + 51);
            childDataList.add(childData1);

            MultiGroupHistogramChildData childData2 = new MultiGroupHistogramChildData();
            childData2.setSuffix("%");
            childData2.setValue(random.nextInt(50) + 51);
            childDataList.add(childData2);
            groupData.setChildDataList(childDataList);
            groupDataList.add(groupData);
        }
        multiGroupHistogramView.setDataList(groupDataList);
        int[] color1 = new int[]{getResources().getColor(R.color.text_blue), getResources().getColor(R.color.text_blue)};

        int[] color2 = new int[]{getResources().getColor(R.color.text_personal_score), getResources().getColor(R.color.text_personal_score)};
        // 设置直方图颜色
        multiGroupHistogramView.setHistogramColor(color1, color2);

    }

    private DoctorJieZhenBean.DataBean bean;
    private List<DoctorJieZhenBean.DataBean.DateListBean> dateList;

    private void setJieZhenData() {

                bean = new DoctorJieZhenBean.DataBean();
                bean.setMax(22.5);
                 bean.setCount(170);

        dateList=new ArrayList<>();
        DoctorJieZhenBean.DataBean.DateListBean bean1=new DoctorJieZhenBean.DataBean.DateListBean();
        bean1.setContent("3");
        bean1.setPatientAge(0);
        bean1.setCreateDate("2019-02-18");
        bean1.setOrderIdStr("ss");
        bean1.setQueueNo(0);
        dateList.add(bean1);

        DoctorJieZhenBean.DataBean.DateListBean bean2=new DoctorJieZhenBean.DataBean.DateListBean();
        bean2.setContent("1");
        bean2.setPatientAge(0);
        bean2.setCreateDate("2019-02-20");
        bean2.setOrderIdStr("ss");
        bean2.setQueueNo(0);
        dateList.add(bean2);

        DoctorJieZhenBean.DataBean.DateListBean bean3=new DoctorJieZhenBean.DataBean.DateListBean();
        bean3.setContent("14");
        bean3.setPatientAge(0);
        bean3.setCreateDate("2019-02-24");
        bean3.setOrderIdStr("ss");
        bean3.setQueueNo(0);
        dateList.add(bean3);

        DoctorJieZhenBean.DataBean.DateListBean bean4=new DoctorJieZhenBean.DataBean.DateListBean();
        bean4.setContent("18");
        bean4.setPatientAge(0);
        bean4.setCreateDate("2019-02-28");
        bean4.setOrderIdStr("ss");
        bean4.setQueueNo(0);
        dateList.add(bean4);
        bean.setDateList(dateList);

        chatLineView.setValue(bean, new ChartView.SetOnitemClickListener() {
                    @Override
                    public void updateTime(int position) {
                    }
                });

    }

    private String[] colors = {"#EB0027", "#F17900", "#4ECB74", "#00DAF9", "#FFBE00", "#1CA8FF", "#975FE4", "#F2637B", "#FFDB4C", "#36CBCB",
            "#74EEFF", "#FF9327", "#168FFF", "#6F19E5", "#FF9191", "#FF5700", "#009A9A", "#0055A5", "#D94BE9"};

    private List<MonthReportJiaoyiBean.DataBean> lists = new ArrayList<>();

    private void initPiechart()
    {
        for(int i=0;i<18;i++)
        {
            MonthReportJiaoyiBean.DataBean dataBean=new MonthReportJiaoyiBean.DataBean();
            dataBean.setBizTypeName("我们"+i);
            dataBean.setSuccessSum(600*i);
            dataBean.setSuccessAmt(600*18);
            lists.add(dataBean);
        }

        pieChartView.setData(lists, lists.size(), true,colors);
    }

    private ArrayList<Integer> colorList = new ArrayList<>();//折线的颜色列表
    private ArrayList<String> XLabel = new ArrayList<>(); //X轴上的标签数据列表
    private ArrayList<String> YLabel = new ArrayList<>(); //Y轴上的标签数据列表
    private int width;
    private int height;

    private void initViews() {

        for (int i = 0; i < 30; i++) {
            XLabel.add(2019+""+i);
        }
        for (int i = 0; i < 11; i++) {
            YLabel.add(10*i+"");
        }

        colorList.add(getResources().getColor(R.color.text_blue));

        colorList.add(getResources().getColor(R.color.text_personal_score));

        colorList.add(getResources().getColor(R.color.dark_blue_bg));

        mSkinLineView.setDataColorList(colorList);

        mSkinLineView.setShowGrid(true);

        mSkinLineView.setDottedLine(true);

        mSkinLineView.setGridColor(Color.LTGRAY);

        mSkinLineView.setXYLabel(XLabel, YLabel, getLineViewWidth());

        setYeWuXiangQingData();

    }


    private int getLineViewWidth() {

        width = getWindowManager().getDefaultDisplay().getWidth();

        height = getWindowManager().getDefaultDisplay().getHeight();

        FrameLayout.LayoutParams params

                = (FrameLayout.LayoutParams) mLineLL.getLayoutParams();

        int LineViewWidth = width - params.leftMargin - params.rightMargin;

        mLineLL.measure(width,400);

        return LineViewWidth;

    }

    private List<MonthReportJiaoyiBean.DataBean> list=new ArrayList<>();
    private int maxBishu=4000;
    private int maxMoney=6000;
    private boolean isBishu=true;
    ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
    ArrayList<Integer> dataListBi1 = new ArrayList<Integer>();
    ArrayList<Integer> dataListBi2 = new ArrayList<Integer>();
    ArrayList<Integer> dataListBi3 = new ArrayList<Integer>();
    ArrayList<Integer> dataListMoney1 = new ArrayList<Integer>();
    ArrayList<Integer> dataListMoney2 = new ArrayList<Integer>();
    ArrayList<Integer> dataListMoney3 = new ArrayList<Integer>();

    private void setYeWuXiangQingData() {

        for(int a=0;a<8;a++)
        {
            MonthReportJiaoyiBean.DataBean databean=new MonthReportJiaoyiBean.DataBean();
            if(a==1)
            {
                databean.setRefundAmt(a*20);
                databean.setRefundSum(1800);
                databean.setSuccessAmt(a*50);
                databean.setSuccessSum(1200);
                databean.setTotalAmt(a*80);
                databean.setTotalSum(2400);
                databean.setDt("2020.04."+a);
            }else if(a==2)
            {
                databean.setRefundAmt(a*20);
                databean.setRefundSum(800);
                databean.setSuccessAmt(a*50);
                databean.setSuccessSum(500);
                databean.setTotalAmt(a*80);
                databean.setTotalSum(1200);
                databean.setDt("2020.04."+a);
            }else if(a==3)
            {
                databean.setRefundAmt(a*20);
                databean.setRefundSum(1500);
                databean.setSuccessAmt(a*50);
                databean.setSuccessSum(1150);
                databean.setTotalAmt(a*80);
                databean.setTotalSum(1900);
                databean.setDt("2020.04."+a);
            }
            else
            {
                databean.setRefundAmt(a*20);
                databean.setRefundSum(a*100);
                databean.setSuccessAmt(a*50);
                databean.setSuccessSum(a*150);
                databean.setTotalAmt(a*80);
                databean.setTotalSum(a*200);
                databean.setDt("2020.04."+a);
            }
            list.add(databean);
        }

        XLabel.clear();
        YLabel.clear();
        dataListBi1.clear();
        dataListBi2.clear();
        dataListBi3.clear();
        dataListMoney1.clear();
        dataListMoney2.clear();
        dataListMoney3.clear();

                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setTagDays("key");
                        XLabel.add(list.get(i).getDt());
                        dataListBi1.add(list.get(i).getTotalSum());
                        dataListBi2.add(list.get(i).getSuccessSum());
                        dataListBi3.add(list.get(i).getRefundSum());
                        dataListMoney1.add(list.get(i).getTotalAmt());
                        dataListMoney2.add(list.get(i).getSuccessAmt());
                        dataListMoney3.add(list.get(i).getRefundAmt());

                        if (maxBishu < list.get(i).getTotalSum()) {
                            maxBishu = list.get(i).getTotalSum();
                        }
                        if (maxMoney < list.get(i).getTotalAmt()) {
                            maxMoney = list.get(i).getTotalAmt();
                        }
                    }
                    setZheLineView();

    }

    private void setZheLineView()
    {
        for (int i = 0; i < 11; i++) {
                YLabel.add(maxBishu / 10 * i + "");
        }

        //绘制3线图

        mSkinLineView.setCountDateList(list);

        mSkinLineView.setXYLabel(XLabel, YLabel, getLineViewWidth());

        mLineLL.measure(400,1000);

            dataLists.clear();
            dataLists.add(dataListBi1);
            dataLists.add(dataListBi2);
            dataLists.add(dataListBi3);


        mSkinLineView.setDataList(dataLists,isBishu);

    }

}
