package com.qingguo;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lyt95 on 2016/12/9.
 */

public class WaterActivity9 extends Activity {
    private final int HIGH = 0;

    // 低温线下标
 private boolean mRun=true;
    private  LineChart mChart1=null;
    private TextView Servera1=null;
    private TextView Servera2=null;

    private TextView Servera3=null;

    private TextView Servera4=null;

    private TextView Servera5=null;
    private TextView Servera6=null;
    private TextView Servera7=null;

    private TextView Servera8=null;
    private TextView Servera9=null;
    private TextView Servera10=null;
    private TextView Servera11=null;
    private TextView Servera12=null;
    private TextView Servera13=null;



    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water9);

        //final LineChart mChart = (LineChart) findViewById(R.id.chart);
        Servera1=(TextView) findViewById(R.id.Servera1);
        Servera2=(TextView) findViewById(R.id.Servera2);
        Servera3=(TextView) findViewById(R.id.Servera3);
        Servera4=(TextView) findViewById(R.id.Servera4);
        Servera5=(TextView) findViewById(R.id.Servera5);
        Servera6=(TextView) findViewById(R.id.Servera6);
        Servera7=(TextView) findViewById(R.id.Servera7);
        Servera8=(TextView) findViewById(R.id.Servera8);
        Servera9=(TextView) findViewById(R.id.Servera9);
        Servera10=(TextView) findViewById(R.id.Servera10);
        Servera11=(TextView) findViewById(R.id.Servera11);
        Servera12=(TextView) findViewById(R.id.Servera12);
        Servera13=(TextView) findViewById(R.id.Servera13);


        //refreshChart();

       Thread thread= new Thread(){
            public void run(){
                try {
                    while (mRun) {
                        Thread.sleep(1000);
                        new AnotherTask().execute("JSON");
                        Log.d("Thread1", "Thread one cnt: ");

                    }

                }
                catch (Exception  e){
                    e.printStackTrace();

                }

            }
        };
        thread.start();

    }

    public void onClickReturnWater(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(WaterActivity9.this, SelectWaterActivity.class);
        startActivity(intent);
        finish();
    }
    private class AnotherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String result) {


            //对UI组件的更新操作
            MyApplication app = (MyApplication) getApplication();
            String jsonReader = Tools.getmethods(app.getServerAddress(), "getLocalExplosiveCar","1");
            JSONObject json = null;
            try {
                json = new JSONObject(jsonReader);


            String number = json.optString("number");
            String temperature = json.optString("temperature");
            String liquidLevel = json.optString("liquidLevel");
            String residualDrug = json.optString("residualDrug ");
            String toAdd = json.optString("toAdd");
            String toStay = json.optString("toStay");
            String setvalue = json.optString("setvalue");
            String instant = json.optString("instant");
            String instant1 = json.optString("instant1");
            String instant2 = json.optString("instant2");
            String total = json.optString("total");
            String total1 = json.optString("total1");
            String total2 = json.optString("total2");
            // 增加高温
            Servera1.setText(number + "号车");
            Servera2.setText(temperature + "°C");
            Servera3.setText(liquidLevel+ "m");
            Servera4.setText(residualDrug + "t");
            Servera5.setText(toAdd + "t");
            Servera6.setText(toStay + "t");
            Servera7.setText(setvalue + "t");
            Servera8.setText(instant + "kg/s");
            Servera9.setText(instant1 + "kg/s");
            Servera10.setText(instant2 + "kg/s");
            Servera11.setText(total + "t");
            Servera12.setText(total1 + "t");
            Servera13.setText(total2 + "t");
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("onPostExecute: ",e.toString());
            }

        }
        @Override
        protected String doInBackground(String... params) {
            //耗时的操作
            return params[0];
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       try {
           mRun=false;
       }
       catch (Exception e){
           Log.d("Thread1", e.toString());
       }
    }



    // 初始化数据集，添加一条高温统计折线


    // 初始化数据集，添加一条低温统计折线

}

