package com.qingguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * Created by lyt95 on 2016/12/11.
 */


public class SelectWaterActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_water);
    }
    public void OnClickWater1(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity1.class);

        startActivity(intent);
        finish();
    }
    public void OnClickWater2(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity2.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater3(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity3.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater4(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity4.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater5(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity5.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater6(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity6.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater7(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity7.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater8(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity8.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater9(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity9.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater10(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity10.class);
        startActivity(intent);
        finish();
    }
    public void OnClickWater11(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectWaterActivity.this, WaterActivity11.class);
        startActivity(intent);
        finish();
    }

}