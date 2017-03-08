package com.qingguo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by lyt95 on 2017/1/2.
 */

public class HistoricalTank2 extends Activity {
    private BarChart mBarChart;
    private BarData mBarData;
    private EditText mEditText1;
    private EditText mEditText2;
    private boolean mRun=true;
    private static int startyear;
    private static int startmonth;
    private static int startday;
    private static int overyear;
    private static int overmonth;
    private static int overday;
    private static int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historical_tank2);
        mBarChart = (BarChart) findViewById(R.id.chart);
//        mBarData = getBarData(7, 100);
//        showBarChart(mBarChart, mBarData);
        mEditText1 = (EditText) findViewById(R.id.StartTime);
        mEditText2 = (EditText) findViewById(R.id.OverTime);
        mEditText1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg1();
                    return true;
                }
                return false;
            }
        });

        mEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickDlg2();
                }
            }
        });



    }
    public void onClickReturnHistoricalTank(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalTank2.this, HistoricalTankActivity.class);
        startActivity(intent);
        finish();
    }
    public void findhistory(View view) throws IOException {
        a=(overyear*365+overmonth*30+overday)-(startyear*365+startmonth*30+startday);
        if(a<=0){
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("开始或结束日期错误");//设置对话框的标题
            builder.setMessage("请重新选择开始或结束日期");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(HistoricalTank2.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else {
            try {
                new Thread() {
                    public void run() {
                        try {
                            while (mRun) {
                                Thread.sleep(900);
                                new HistoricalTank2.AnotherTask().execute("JSON");
                                Log.d("Thread1", "Thread one cnt: ");

                            }

                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }.start();

            } catch (Exception x) {
                Log.d("错误", x.toString());
            }
        }
    }
    protected void showDatePickDlg1() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(HistoricalTank2.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                HistoricalTank2.this.mEditText1.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                startyear=year;
                startmonth=monthOfYear;
                startday=dayOfMonth;
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
    protected void showDatePickDlg2() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(HistoricalTank2.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                HistoricalTank2.this.mEditText2.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                overyear=year;
                overmonth=monthOfYear;
                overday=dayOfMonth;
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
    private class AnotherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String result) {
            //对UI组件的更新操作
            mBarData = getBarData(a, 100);
            showBarChart(mBarChart, mBarData);
        }
        @Override
        protected String doInBackground(String... params) {
            //耗时的操作
            return params[0];
        }
    }



    private void showBarChart(BarChart barChart, BarData barData) {
        barChart.setDrawBorders(false);  ////是否在折线图上添加边框

        barChart.setDescription("正在加载中");// 数据描述
        // 如果没有数据的时候，会显示这个，类似ListView的EmptyView
        barChart.setNoDataTextDescription("You need to provide data for the chart.");
        barChart.setDrawGridBackground(false); // 是否显示表格颜色
        barChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度
        barChart.setTouchEnabled(true); // 设置是否可以触摸
        barChart.setDragEnabled(true);// 是否可以拖拽
        barChart.setScaleEnabled(true);// 是否可以缩放



        barChart.setPinchZoom(false);//

//      barChart.setBackgroundColor();// 设置背景

        barChart.setDrawBarShadow(true);
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setStartAtZero(false);          // 不一定要从0开始

        leftAxis.setDrawGridLines(true);
        barChart.getLegend().setXEntrySpace(4f);
        barChart.setData(barData); // 设置数据

        Legend mLegend = barChart.getLegend(); // 设置比例图标示

        mLegend.setForm(LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(6f);// 字体
        mLegend.setTextColor(Color.BLACK);// 颜色
        barChart.setVisibleXRangeMaximum(10);
//      X轴设定
//      XAxis xAxis = barChart.getXAxis();
//      xAxis.setPosition(XAxisPosition.BOTTOM);

        barChart.animateX(2500); // 立即执行的动画,x轴
        mRun=false;
    }


    private BarData getBarData(int count, float range) {
        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i <count; i++) {
            xValues.add("" + (i + 1));
        }

        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();

        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;
            yValues.add(new BarEntry(value, i));
        }

        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "机油罐");

        barDataSet.setColor(Color.rgb(114, 188, 223));

        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();
        barDataSets.add(barDataSet); // add the datasets

        barDataSet.setDrawValues(true);//是否显示柱子上面的数值

        BarData barData = new BarData(xValues, barDataSets);

        return barData;
    }

}