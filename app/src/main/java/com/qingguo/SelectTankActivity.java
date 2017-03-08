package com.qingguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * Created by lyt95 on 2016/12/11.
 */

public class SelectTankActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_tank);
    }
    public void OnClickTank1(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectTankActivity.this, TankActivity1.class);
        startActivity(intent);
        finish();
    }
    public void OnClickTank2(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectTankActivity.this, TankActivity2.class);
        startActivity(intent);
        finish();
    }
    public void OnClickTank3(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectTankActivity.this, TankActivity3.class);
        startActivity(intent);
        finish();
    }
    public void OnClickTank4(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectTankActivity.this, TankActivity4.class);
        startActivity(intent);
        finish();
    }
    public void OnClickTank5(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectTankActivity.this, TankActivity5.class);
        startActivity(intent);
        finish();
    }
    public void OnClickTank6(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectTankActivity.this, TankActivity6.class);
        startActivity(intent);
        finish();
    }
}