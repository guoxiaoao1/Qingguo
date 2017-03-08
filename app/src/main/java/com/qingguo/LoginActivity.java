package com.qingguo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lyt95 on 2017/1/2.
 */
public class LoginActivity extends Activity {

    private EditText createUsername;
    private EditText createUserPassword;
    private EditText createUserPassWorldSecond;
    private EditText serviceAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClickReturnMenu(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void onClickLogin(View view) throws IOException {

        createUsername=(EditText)findViewById(R.id.CreateUsername);
        createUserPassword=(EditText)findViewById(R.id.CreateUserPassword);
        createUserPassWorldSecond=(EditText)findViewById(R.id.CreateUserPassWorldSecond);
        serviceAddress=(EditText)findViewById(R.id.ServiceAddress);
        Pattern pattern = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
        android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
        builder.setTitle("注册失败");//设置对话框的标题

        if (createUsername.getText().toString().length()==0){
            builder.setMessage("用户名不能为空");//设置对话框的内容
        }
        else if(createUserPassword.getText().toString().length()==0
                ||createUserPassWorldSecond.getText().toString().length()==0
                ||!createUserPassword.getText().toString().equals(createUserPassWorldSecond.getText().toString())){
                builder.setMessage("二次输入的密码不一致");//设置对话框的内容
        }else if (serviceAddress.getText().toString().length()==0){
            builder.setMessage("服务器地址不能为空");//设置对话框的内容
        } else{
                 Matcher matcher = pattern.matcher(serviceAddress.getText().toString());
                if(!matcher.matches()){
                    builder.setMessage("服务器地址输入错误");//设置对话框的内容
                }else{
                    builder.setMessage("正在注册");//设置对话框的内容
                    builder.setMessage("注册失败");//设置对话框的内容
                 /*   if (Tools.register(createUsername.getText().toString(),createUserPassword.getText().toString(),serviceAddress.getText().toString())){
                        builder.setMessage("注册失败");//设置对话框的内容
                    }else{
                        builder.setMessage("注册失败，已被他人注册");//设置对话框的内容
                    }*/

                }
        }



        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(LoginActivity.this, "返回", Toast.LENGTH_SHORT).show();

            }
        });
        android.app.AlertDialog b=builder.create();
        b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
    }
}