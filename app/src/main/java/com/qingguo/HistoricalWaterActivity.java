package com.qingguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * Created by lyt95 on 2017/1/2.
 */

public class HistoricalWaterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historical_water);
    }

    public void OnClickHistoricalWater1(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalWaterActivity.this, HistoricalWater1.class);
        startActivity(intent);
        finish();
    }
    public void OnClickHistoricalWater2(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalWaterActivity.this, HistoricalWater2.class);
        startActivity(intent);
        finish();
    }
    public void OnClickHistoricalWater3(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalWaterActivity.this, HistoricalWater3.class);
        startActivity(intent);
        finish();
    }
    public void OnClickHistoricalWater4(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalWaterActivity.this, HistoricalWater4.class);
        startActivity(intent);
        finish();
    }
}