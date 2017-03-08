package com.qingguo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lyt95 on 2016/12/9.
 */

public class WaterActivity7 extends Activity {
    private final int HIGH = 0;
    private boolean mRun=true;
    private TextView Servera=null;
    private TextView Servera2=null;

    private LineChart linechart1=null;
    private LineChart linechart2=null;

    private List<LineChart> first=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water7);

        try {


            //final LineChart mChart = (LineChart) findViewById(R.id.chart);
            linechart1 =(LineChart) findViewById(R.id.chart);
            linechart2=(LineChart)findViewById(R.id.chart2);
            Servera=(TextView) findViewById(R.id.Servera1);
            Servera2=(TextView) findViewById(R.id.Servera2);
            first.add(linechart1);
            first.add(linechart2);
            initialChart(first);
            addLineDataSet(first);

            //refreshChart();

            new Thread(){
                public void run(){
                    try {
                        while (mRun) {
                            Thread.sleep(900);
                            new AnotherTask().execute("JSON");
                            Log.d("Thread1", "Thread one cnt: ");

                        }

                    }
                    catch (Exception  e){
                        e.printStackTrace();

                    }

                }
            }.start();

        }catch (Exception  x){
            Log.d("错误", x.toString());
        }



    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mRun=false;
    }
    public void onClickReturnWater(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(WaterActivity7.this, SelectWaterActivity.class);
        startActivity(intent);
        finish();
    }
    private class AnotherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String result) {
            //对UI组件的更新操作
            addEntry(first);
        }
        @Override
        protected String doInBackground(String... params) {
            //耗时的操作
            return params[0];
        }
    }




    private void initialChart(List<LineChart> mChart) {

        for(LineChart linechart:mChart) {
            linechart.setNoDataTextDescription("暂时尚无数据");
            linechart.setTouchEnabled(true);
            // 可拖曳
            linechart.setDragEnabled(true);
            // 可缩放
            linechart.setScaleEnabled(true);
            linechart.setDrawGridBackground(false);
            linechart.setPinchZoom(true);
            // 设置图表的背景颜色
            linechart.setBackgroundColor(0xfff5f5f5);

            // 图表的注解(只有当数据集存在时候才生效)
            Legend l = linechart.getLegend();

            // 可以修改图表注解部分的位置
            //l.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

            // 线性，也可是圆
            l.setForm(LegendForm.LINE);

            // 颜色
            l.setTextColor(Color.CYAN);

            // x坐标轴
            XAxis xl = linechart.getXAxis();
            xl.setTextColor(0xff00897b);
            xl.setDrawGridLines(false);
            xl.setAvoidFirstLastClipping(true);

            // 几个x坐标轴之间才绘制？
            xl.setSpaceBetweenLabels(5);

            // 如果false，那么x坐标轴将不可见
            xl.setEnabled(true);

            // 将X坐标轴放置在底部，默认是在顶部。
            xl.setPosition(XAxisPosition.BOTTOM);

            // 图表左边的y坐标轴线
            YAxis leftAxis = linechart.getAxisLeft();
            leftAxis.setTextColor(0xff37474f);

            // 最大值


            // 不一定要从0开始
            leftAxis.setStartAtZero(false);

            leftAxis.setDrawGridLines(true);

            YAxis rightAxis = linechart.getAxisRight();
            // 不显示图表的右边y坐标轴线
            rightAxis.setEnabled(false);


            if(linechart==linechart1) {

                leftAxis.setAxisMaxValue(120f);

                // 最小值
                leftAxis.setAxisMinValue(-40f);
            }else{
                leftAxis.setAxisMaxValue(7f);

                // 最小值
                leftAxis.setAxisMinValue(0f);
            }


        }
    }
    // 为LineChart增加LineDataSet
    private void addLineDataSet(List<LineChart> mChart) {

        for (LineChart linechart : mChart) {
            LineData data = new LineData();

            data.addDataSet(createHighLineDataSet());

            // 数据显示的颜色
            data.setValueTextColor(Color.BLUE);

            // 先增加一个空的数据，随后往里面动态添加
            linechart.setData(data);
        }
    }

    // 同时为高温线和低温线添加进去一个坐标点
    private void addEntry(List<LineChart> mChart) {
        try {


            MyApplication app = (MyApplication) getApplication();
            String jsonReader=Tools.getmethods(app.getServerAddress(),"getStorageTanks","14");
            JSONObject json=new JSONObject(jsonReader);

            String temperature = json.optString("temperature");
            String liquidLevel=json.optString("liquidLevel");



            // int str = Tools.getnumber(app.getServerAddress());





            for (LineChart linechart : mChart) {
                LineData data = linechart.getData();
                Calendar c = Calendar.getInstance();
                int second  = c.get(Calendar.SECOND);
                int minute = c.get(Calendar.MINUTE);
                data.addXValue(minute+":"+second  + "");



                if(linechart==linechart1) {
                    // 增加高温
                    LineDataSet highLineDataSet = data.getDataSetByIndex(HIGH);
                    float fh = Float.parseFloat (temperature);
                    Entry entryh = new Entry(fh, highLineDataSet.getEntryCount());
                    data.addEntry(entryh, HIGH);


                }else{
                    // 增加高温
                    LineDataSet highLineDataSet = data.getDataSetByIndex(HIGH);
                    float fh = Float.parseFloat (liquidLevel);
                    Entry entryh = new Entry(fh, highLineDataSet.getEntryCount());
                    data.addEntry(entryh, HIGH);

                }





                Servera.setText(temperature+"°C");
                Servera2.setText(liquidLevel+"m");

                linechart.notifyDataSetChanged();

                // 当前统计图表中最多在x轴坐标线上显示的总量
                linechart.setVisibleXRangeMaximum(5);

                linechart.moveViewToX(data.getXValCount() - 5);

            }

        }
        catch (Exception  x){
            Log.d("错误", x.toString());
        }



    }

    // 初始化数据集，添加一条高温统计折线
    private LineDataSet createHighLineDataSet() {

        LineDataSet set = new LineDataSet(null, "");
        set.setAxisDependency(AxisDependency.LEFT);
        // 折线的颜色
        set.setColor(Color.rgb(51,204,153));
        set.setCircleColor(Color.YELLOW);
        set.setLineWidth(5f);
        set.setCircleSize(10f);
        // set.setFillAlpha(128);
        set.setCircleColorHole(Color.BLUE);
        set.setHighLightColor(Color.GREEN);
        set.setValueTextColor(Color.RED);
        set.setValueTextSize(10f);
        set.setDrawValues(true);

        set.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex,
                                            ViewPortHandler viewPortHandler) {
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
//                DecimalFormat decimalFormat = new DecimalFormat("高温");
//                DecimalFormat decimalFormat = new DecimalFormat(".0℃");
//                String s = "高温" + decimalFormat.format(value);
                String s =  decimalFormat.format(value);
                return s;
            }
        });

        return set;
    }


}

