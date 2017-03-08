package com.qingguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * Created by lyt95 on 2017/1/2.
 */

public class HistoricalExplosiveActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historical_explosive);
    }
    public void OnClickHistoricalExplosive1(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(HistoricalExplosiveActivity.this, HistoricalExplosive1.class);
        startActivity(intent);
        finish();
    }
}