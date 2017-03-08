package com.qingguo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by lyt95 on 2017/1/1.
 */

public class TrafficActivity extends Activity{
    private TextView Update=null;
    int year=0;
    int month=0;
    int day=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
    }
    public void OnClickStop(View view) throws IOException {
        Intent intent = new Intent(TrafficActivity.this, FxService.class);
        stopService(intent);
    }
    public void OnClickStart(View view) throws IOException {
        // TODO Auto-generated method stub
        Intent intent = new Intent(TrafficActivity.this, FxService.class);
        startService(intent);
    }
    public void shuaxin(View view) throws IOException {
        Update=(TextView) findViewById(R.id.update);
        try {
            PackageManager pm = getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo("com.qingguo", PackageManager.GET_ACTIVITIES);
            Log.d("!!", "!!" + ai.uid);
            long rUid = TrafficStats.getUidRxBytes(ai.uid);
            long tUid = TrafficStats.getUidTxBytes(ai.uid);
            double totalUid=rUid+tUid;
            java.text.DecimalFormat df=new java.text.DecimalFormat("#.##");
            Update.setText(df.format(totalUid/1048576)+"MB");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}