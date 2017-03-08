package com.qingguo;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Toast;


public class DetectionActivity extends FragmentActivity
{
    private TabHost mTabHost;
    private static boolean isExit = false;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);
        //取得TabHost对象
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        //为TabHost添加标签
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("实时数据",getResources().getDrawable(R.drawable.tab_tbox1)).setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("历史数据",getResources().getDrawable(R.drawable.tab_tbox2)).setContent(R.id.tab2));
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("报表",getResources().getDrawable(R.drawable.tab_tbox3)).setContent(R.id.tab3));
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("设置",getResources().getDrawable(R.drawable.tab_tbox4)).setContent(R.id.tab4));
        //设置TabHost的背景颜色
        mTabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));
        //设置当前显示哪一个标签
        mTabHost.setCurrentTab(0);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    public void OnClickSelectExplosive(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, SelectExplosiveActivity.class);
        startActivity(intent);
    }
    public void OnClickSelectWater(View view) throws IOException {
    Intent intent = new Intent();
    intent.setClass(DetectionActivity.this, SelectWaterActivity.class);
    startActivity(intent);
}
    public void OnClickSelectTank(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, SelectTankActivity.class);
        startActivity(intent);
    }
    public void OnClickSelectVideo(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, SelectVideoActivity.class);
        startActivity(intent);
    }
    public void OnClickTraffic(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, TrafficActivity.class);
        startActivity(intent);
    }
    public void OnClickHistoricalTank(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, HistoricalTankActivity.class);
        startActivity(intent);
    }
    public void OnClickHistoricalExplosive(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, HistoricalExplosiveActivity.class);
        startActivity(intent);
    }
    public void OnClickHistoricalWater(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, HistoricalWaterActivity.class);
        startActivity(intent);
    }
    public void OnClickWarning(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(DetectionActivity.this, WarningActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
