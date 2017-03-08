package com.qingguo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by lyt95 on 2017/1/2.
 */

public class HistoricalTankActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historical_tank);
    }
    public void OnClickHistoricalTank1(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalTankActivity.this, HistoricalTank1.class);
        startActivity(intent);
        finish();
    }
    public void OnClickHistoricalTank2(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalTankActivity.this, HistoricalTank2.class);
        startActivity(intent);
        finish();
    }
    public void OnClickHistoricalTank3(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalTankActivity.this, HistoricalTank3.class);
        startActivity(intent);
        finish();
    }
    public void OnClickHistoricalTank4(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalTankActivity.this, HistoricalTank4.class);
        startActivity(intent);
        finish();
    }
}