package com.qingguo.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.qingguo.MainActivity;
import com.qingguo.R;
import com.qingguo.Tools;
import com.qingguo.tools.serialNumber;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangquan on 2017/1/1.
 */

public class WarningService  extends Service {


    private int i=1000;
    private int multiple=2;
    private boolean threadDisable=true;

    private NotificationManager manager;
    private Notification.Builder builder;
    private PendingIntent intent;
    private String ServiceIP;


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.e("LOG", "iBinder------------------->");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        ServiceIP=intent.getStringExtra("ServiceIP");

        return START_STICKY;
    }


    @Override
    public void onCreate() {



        // TODO Auto-generated method stub
        Log.e("LOG", "onCreate------------------->");
        super.onCreate();


        manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        //新建一个Notification管理器;
        //API level 11
        builder = new Notification.Builder(this);//新建Notification.Builder对象
        intent = PendingIntent.getService(this, 0, new Intent(this, WarningService.class), 0);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (threadDisable) {
                    try {
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String jsonReader= Tools.getmethods(ServiceIP,"getWarningNumber","");

                    if (!jsonReader.equals("timeout")) {
                        i=1000; //如果不超时的话每次都从服务器获取数据，
                        // 发送通知

                        JSONObject json= null;
                        try {
                            json = new JSONObject(jsonReader);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String Warning = json.optString("Warning");

                        if(Warning.equals("noWarning")){
                            continue;
                        }else{
                            WarningBoxStyle(serialNumber.serialnumbertoList(Warning));

                        }
                    if (i==8000){
                        multiple=4;
                    }
                    }

                    if (jsonReader.equals("timeout")){
                        i=i*multiple; //如果超时，堵塞时间翻倍

                        String title="";
                        String text="";
                        String bigContentTitle="";
                        String contentText="";
                        String timeText;
                        if((i/1000)<60){
                            timeText=i/1000+"秒后重新连接服务器";
                        }else{
                            timeText=(i/1000)/60+"分钟后重新连接服务器";
                        }
                        text="详细内容请下拉";
                        bigContentTitle="服务器连接超时。";
                        contentText="为了保证服务器高效运作，每次连接失败，再次连接的时间翻倍，你可以尝试重启应用已获得立即连接.";

                        //PendingIntent点击通知后所跳转的页面
                        timeOutBoxStyle(title,text,bigContentTitle,contentText,timeText);


                    }

                    if (i>1024000){   // 等待 2 4 8 分钟之后还没有找到服务器，关闭从服务器获取数据的线程

                        String title="";
                        String text="";
                        String bigContentTitle="";
                        String contentText="";
                        String timeText;
                        timeText="关闭应用连接服务器";
                        text="详细内容请下拉";
                        bigContentTitle="关闭应用连接服务器。";
                        contentText="为了保证服务器高效运作，其次尝试连接失败后关闭后台服务连接服务器，若要连接服务器请重启应用，若不连接服务请忽略本条信息";
                        //PendingIntent点击通知后所跳转的页面
                        timeOutBoxStyle(title,text,bigContentTitle,contentText,timeText);
                    }
                }
            }
        }).start();

    }

    @Override
    public void onDestroy() {


        super.onDestroy();

    }

    public void WarningBoxStyle(StringBuilder warningBuilder){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("预警");
        builder.setContentText("详细数据请下拉");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        android.support.v4.app.NotificationCompat.BigTextStyle style = new android.support.v4.app.NotificationCompat.BigTextStyle();
        style.setBigContentTitle("预警数据如下");
        style.bigText(warningBuilder.toString());
        style.setSummaryText("点击可以关闭");
        builder.setStyle(style);
        builder.setAutoCancel(true);

        //点击通知栏之后跳转登录页面 WarningService
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pIntent = PendingIntent.getService(this,1,intent,0);

        //builder.setFullScreenIntent(pIntent,true);
        builder.setContentIntent(pIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(1,notification);
    }

    public void timeOutBoxStyle(String title,String text,String bigContentTitle,String contentText,String timeText){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.textview_border));
        android.support.v4.app.NotificationCompat.BigTextStyle style = new android.support.v4.app.NotificationCompat.BigTextStyle();
        style.bigText(contentText);
        style.setBigContentTitle(bigContentTitle);
        //SummaryText没什么用 可以不设置

        style.setSummaryText(timeText);
        builder.setStyle(style);
        builder.setAutoCancel(true);

        Intent intent = new Intent(this,WarningService.class);
        PendingIntent pIntent = PendingIntent.getService(this,1,intent,0);
        builder.setFullScreenIntent(pIntent,true);
        builder.setContentIntent(pIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(1,notification);
    }


}
