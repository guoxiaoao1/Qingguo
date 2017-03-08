package com.qingguo.tools;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by wangquan on 2017/1/1.
 */

public class NetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.SCREEN_ON")){
            System.out.println("解锁了    我在屏幕上 ...");
        }else if(intent.getAction().equals("android.intent.action.SCREEN_OFF")){
            System.out.println("锁屏了   看不见我...");
        }else if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            System.out.println("解锁屏了    home 我在桌面上...");
        }
    }

}
