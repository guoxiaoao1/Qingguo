package com.qingguo;

import android.app.Application;

/**
 * Created by lyt95 on 2016/12/11.
 */

public class MyApplication extends Application {

    public String getuserName() {
        return UserName;
    }

    public void setuserName(String userName) {
        UserName = userName;
    }

    private String UserName;

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String serverAddress;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String passWord;

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }

}
