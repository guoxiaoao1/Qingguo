package com.qingguo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.qingguo.Service.WarningService;
import com.qingguo.tools.RunningTaskInfo;

import java.io.IOException;

import static com.qingguo.Tools.check;

public class MainActivity extends AppCompatActivity {

    private Intent localIntent=new Intent();
    private boolean serverup=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        EditText Username = (EditText) findViewById(R.id.userName);        //编辑框对象
        EditText Password = (EditText) findViewById(R.id.userPassword);
        EditText Serveraddress = (EditText) findViewById(R.id.serverAddress);
        SharedPreferences preference = getSharedPreferences("person", Context.MODE_PRIVATE);
        if (preference.getString("User", String.valueOf(Username)).length() >= 50) {
            Username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText et = (EditText) v;
                    if (!hasFocus) {// 失去焦点
                        et.setHint(et.getTag().toString());
                    } else {
                        String hint = et.getHint().toString();
                        et.setTag(hint);//保存预设字
                        et.setHint(null);
                    }
                }
            });
            //password焦点监听事件
            Password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText et = (EditText) v;
                    if (!hasFocus) {// 失去焦点
                        et.setHint(et.getTag().toString());
                    } else {
                        String hint = et.getHint().toString();
                        et.setTag(hint);//保存预设字
                        et.setHint(null);
                    }
                }
            });
            Serveraddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText et = (EditText) v;
                    if (!hasFocus) {// 失去焦点
                        et.setHint(et.getTag().toString());
                    } else {
                        String hint = et.getHint().toString();
                        et.setTag(hint);//保存预设字
                        et.setHint(null);
                    }
                }
            });
        } else {
            Username.setText(preference.getString("User", String.valueOf(Username).length() >= 50 ? "请输入用户名" : String.valueOf(Username)));            //preference.getString(标示符,默认值<这里为空>）
            Password.setText(preference.getString("Psw", String.valueOf(Password).length() >= 50 ? "123456" : String.valueOf(Password)));
            Serveraddress.setText(preference.getString("IP", String.valueOf(Serveraddress).length() >= 50 ? "请输入IP" : String.valueOf(Serveraddress)));
        }
    }
    public void register(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void OnClickLogin(View view) throws IOException {


        String username = "";
        String userpassword = "";
        String serveraddress = "";
        EditText editText1 = (EditText) findViewById(R.id.userName);
        EditText editText2 = (EditText) findViewById(R.id.userPassword);
        EditText editText3 = (EditText) findViewById(R.id.serverAddress);
        username = editText1.getText().toString();
        userpassword = editText2.getText().toString();
        serveraddress = editText3.getText().toString();

        if ((check(username, userpassword, serveraddress))) {

            Intent intent = new Intent();
            intent.setClass(MainActivity.this, DetectionActivity.class);
            startActivity(intent);
            intent.putExtra("str1", username);
            intent.putExtra("str2", userpassword);
            intent.putExtra("str3", serveraddress);
            MainActivity.this.startActivity(intent);

            EditText Username = (EditText) findViewById(R.id.userName);        //编辑框对象
            EditText Password = (EditText) findViewById(R.id.userPassword);
            EditText Serveraddress = (EditText) findViewById(R.id.serverAddress);


            String User = Username.getText().toString();
            String Psw = Password.getText().toString();
            String IP = Serveraddress.getText().toString();

            SharedPreferences preference = getSharedPreferences("person", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("User", User);

            edit.putString("Psw", Psw);

            edit.putString("IP", IP);

            MyApplication app=(MyApplication)getApplication();
            app.setServerAddress(IP);
            app.setPassWord(Psw);
            app.setuserName(User);

            serverup=true;
            localIntent.setClass(this, WarningService.class);
            localIntent.putExtra("ServiceIP",IP);
            this.startService(localIntent);



            edit.commit();
            finish();
        }else {
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("用户名或密码错误");//设置对话框的标题
            builder.setMessage("请重新输入用户名或密码");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }


    @Override
    protected void onStop() {

        //应用关闭，关闭后台心跳算法

        if (!RunningTaskInfo.isBackground(MyApplication.getInstance())&&serverup==true){
                this.stopService(localIntent);
        }
        //Log.i(TAG, "onStop");
        super.onStop();
    }


}