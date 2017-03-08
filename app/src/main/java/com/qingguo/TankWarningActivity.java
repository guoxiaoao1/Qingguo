package com.qingguo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by lyt95 on 2017/1/13.
 */

public class TankWarningActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tank_warning);
        TextView setvalueTank1 = (TextView) findViewById(R.id.setvalueTankWarning1);
        TextView setvalueTank2 = (TextView) findViewById(R.id.setvalueTankWarning2);
        TextView setvalueTank3 = (TextView) findViewById(R.id.setvalueTankWarning3);
        TextView setvalueTank4 = (TextView) findViewById(R.id.setvalueTankWarning4);
        TextView setvalueTank5 = (TextView) findViewById(R.id.setvalueTankWarning5);
        TextView setvalueTank6 = (TextView) findViewById(R.id.setvalueTankWarning6);
        SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);
        setvalueTank1.setText(preference.getString("Tank1", String.valueOf(setvalueTank1).length() >= 50 ? "无数据" : String.valueOf(setvalueTank1)));
        setvalueTank2.setText(preference.getString("Tank2", String.valueOf(setvalueTank2).length() >= 50 ? "无数据" : String.valueOf(setvalueTank2)));
        setvalueTank3.setText(preference.getString("Tank3", String.valueOf(setvalueTank3).length() >= 50 ? "无数据" : String.valueOf(setvalueTank3)));
        setvalueTank4.setText(preference.getString("Tank4", String.valueOf(setvalueTank4).length() >= 50 ? "无数据" : String.valueOf(setvalueTank4)));
        setvalueTank5.setText(preference.getString("Tank5", String.valueOf(setvalueTank5).length() >= 50 ? "无数据" : String.valueOf(setvalueTank5)));
        setvalueTank6.setText(preference.getString("Tank6", String.valueOf(setvalueTank6).length() >= 50 ? "无数据" : String.valueOf(setvalueTank6)));
//        buttun.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
    public void ChangesetvaluesetvalueTankWarning1(View view) throws IOException {
        EditText editText1 = (EditText) findViewById(R.id.getsetvaluesetvalueTankWarning1);
        String Tanksetvalue1 = editText1.getText().toString();
        if(Tanksetvalue1.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Tank1", Tanksetvalue1);
            edit.commit();
            TextView setvalueTank1 = (TextView) findViewById(R.id.setvalueTankWarning1);
            setvalueTank1.setText(Tanksetvalue1);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改柴油罐设定值成功");//设置对话框的标题
            builder.setMessage("修改柴油罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else{
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("请输入正确的设定值");//设置对话框的标题
            builder.setMessage("请输入正确的设定值");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueTankWarning2(View view) throws IOException {
        EditText editText2 = (EditText) findViewById(R.id.getsetvaluesetvalueTankWarning2);
        String Tanksetvalue2 = editText2.getText().toString();
        if(Tanksetvalue2.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Tank2", Tanksetvalue2);
            edit.commit();
            TextView setvalueTank2 = (TextView) findViewById(R.id.setvalueTankWarning2);
            setvalueTank2.setText(Tanksetvalue2);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改机油罐设定值成功");//设置对话框的标题
            builder.setMessage("修改机油罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else{
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("请输入正确的设定值");//设置对话框的标题
            builder.setMessage("请输入正确的设定值");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueTankWarning3(View view) throws IOException {
        EditText editText3 = (EditText) findViewById(R.id.getsetvaluesetvalueTankWarning3);
        String Tanksetvalue3 = editText3.getText().toString();
        if(Tanksetvalue3.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Tank3", Tanksetvalue3);
            edit.commit();
            TextView setvalueTank3 = (TextView) findViewById(R.id.setvalueTankWarning3);
            setvalueTank3.setText(Tanksetvalue3);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改1#乳化剂罐设定值成功");//设置对话框的标题
            builder.setMessage("修改1#乳化剂罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else{
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("请输入正确的设定值");//设置对话框的标题
            builder.setMessage("请输入正确的设定值");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueTankWarning4(View view) throws IOException {
        EditText editText4 = (EditText) findViewById(R.id.getsetvaluesetvalueTankWarning4);
        String Tanksetvalue4 = editText4.getText().toString();
        if(Tanksetvalue4.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Tank4", Tanksetvalue4);
            edit.commit();
            TextView setvalueTank4 = (TextView) findViewById(R.id.setvalueTankWarning4);
            setvalueTank4.setText(Tanksetvalue4);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改2#乳化剂罐设定值成功");//设置对话框的标题
            builder.setMessage("修改2#乳化剂罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else{
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("请输入正确的设定值");//设置对话框的标题
            builder.setMessage("请输入正确的设定值");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueTankWarning5(View view) throws IOException {
        EditText editText5 = (EditText) findViewById(R.id.getsetvaluesetvalueTankWarning5);
        String Tanksetvalue5 = editText5.getText().toString();
        if(Tanksetvalue5.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Tank5", Tanksetvalue5);
            edit.commit();
            TextView setvalueTank5 = (TextView) findViewById(R.id.setvalueTankWarning5);
            setvalueTank5.setText(Tanksetvalue5);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改1#制备罐设定值成功");//设置对话框的标题
            builder.setMessage("修改1#制备罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else{
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("请输入正确的设定值");//设置对话框的标题
            builder.setMessage("请输入正确的设定值");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueTankWarning6(View view) throws IOException {
        EditText editText6 = (EditText) findViewById(R.id.getsetvaluesetvalueTankWarning6);
        String Tanksetvalue6 = editText6.getText().toString();
        if(Tanksetvalue6.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueTank", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Tank6", Tanksetvalue6);
            edit.commit();
            TextView setvalueTank6 = (TextView) findViewById(R.id.setvalueTankWarning6);
            setvalueTank6.setText(Tanksetvalue6);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改2#储存罐设定值成功");//设置对话框的标题
            builder.setMessage("修改2#储存罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }else{
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("请输入正确的设定值");//设置对话框的标题
            builder.setMessage("请输入正确的设定值");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TankWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
}