package com.qingguo;

/**
 * Created by lyt95 on 2017/1/10.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * Created by lyt95 on 2016/12/14.
 */

public class WarningActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);
//        buttun.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
    public void OnClickTankWarning(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(WarningActivity.this, TankWarningActivity.class);
        startActivity(intent);
        finish();
    }
    public void OnClickExplosiveWarning(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(WarningActivity.this, ExplosiveWarningActivity.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWaterWarning(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(WarningActivity.this, WaterWarningActivity.class);
        startActivity(intent);
        finish();
    }
}

