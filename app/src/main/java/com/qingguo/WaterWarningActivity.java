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

public class WaterWarningActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_warning);
        TextView setvalueWater1 = (TextView) findViewById(R.id.setvalueWaterWarning1);
        TextView setvalueWater2 = (TextView) findViewById(R.id.setvalueWaterWarning2);
        TextView setvalueWater3 = (TextView) findViewById(R.id.setvalueWaterWarning3);
        TextView setvalueWater4 = (TextView) findViewById(R.id.setvalueWaterWarning4);
        TextView setvalueWater5 = (TextView) findViewById(R.id.setvalueWaterWarning5);
        TextView setvalueWater6 = (TextView) findViewById(R.id.setvalueWaterWarning6);
        TextView setvalueWater7 = (TextView) findViewById(R.id.setvalueWaterWarning7);
        TextView setvalueWater8 = (TextView) findViewById(R.id.setvalueWaterWarning8);
        SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);
        setvalueWater1.setText(preference.getString("Water1", String.valueOf(setvalueWater1).length() >= 50 ? "无数据" : String.valueOf(setvalueWater1)));
        setvalueWater2.setText(preference.getString("Water2", String.valueOf(setvalueWater2).length() >= 50 ? "无数据" : String.valueOf(setvalueWater2)));
        setvalueWater3.setText(preference.getString("Water3", String.valueOf(setvalueWater3).length() >= 50 ? "无数据" : String.valueOf(setvalueWater3)));
        setvalueWater4.setText(preference.getString("Water4", String.valueOf(setvalueWater4).length() >= 50 ? "无数据" : String.valueOf(setvalueWater4)));
        setvalueWater5.setText(preference.getString("Water5", String.valueOf(setvalueWater5).length() >= 50 ? "无数据" : String.valueOf(setvalueWater5)));
        setvalueWater6.setText(preference.getString("Water6", String.valueOf(setvalueWater6).length() >= 50 ? "无数据" : String.valueOf(setvalueWater6)));
        setvalueWater7.setText(preference.getString("Water7", String.valueOf(setvalueWater7).length() >= 50 ? "无数据" : String.valueOf(setvalueWater7)));
        setvalueWater8.setText(preference.getString("Water8", String.valueOf(setvalueWater8).length() >= 50 ? "无数据" : String.valueOf(setvalueWater8)));
//        buttun.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
    public void ChangesetvaluesetvalueWaterWarning1(View view) throws IOException {
        EditText editText1 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning1);
        String watersetvalue1 = editText1.getText().toString();
        if(watersetvalue1.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water1", watersetvalue1);
            edit.commit();
            TextView setvaluewater1 = (TextView) findViewById(R.id.setvalueWaterWarning1);
            setvaluewater1.setText(watersetvalue1);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改热水罐设定值成功");//设置对话框的标题
            builder.setMessage("修改热水罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning2(View view) throws IOException {
        EditText editText2 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning2);
        String watersetvalue2 = editText2.getText().toString();
        if(watersetvalue2.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water2", watersetvalue2);
            edit.commit();
            TextView setvaluewater2 = (TextView) findViewById(R.id.setvalueWaterWarning2);
            setvaluewater2.setText(watersetvalue2);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改1#蒸汽罐设定值成功");//设置对话框的标题
            builder.setMessage("修改1#蒸汽罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning3(View view) throws IOException {
        EditText editText3 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning3);
        String watersetvalue3 = editText3.getText().toString();
        if(watersetvalue3.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water3", watersetvalue3);
            edit.commit();
            TextView setvaluewater3 = (TextView) findViewById(R.id.setvalueWaterWarning3);
            setvaluewater3.setText(watersetvalue3);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改2#蒸汽罐设定值成功");//设置对话框的标题
            builder.setMessage("修改2#蒸汽罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning4(View view) throws IOException {
        EditText editText4 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning4);
        String watersetvalue4 = editText4.getText().toString();
        if(watersetvalue4.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water4", watersetvalue4);
            edit.commit();
            TextView setvaluewater4 = (TextView) findViewById(R.id.setvalueWaterWarning4);
            setvaluewater4.setText(watersetvalue4);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改1#溶解罐设定值成功");//设置对话框的标题
            builder.setMessage("修改1#溶解罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning5(View view) throws IOException {
        EditText editText5 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning5);
        String watersetvalue5 = editText5.getText().toString();
        if(watersetvalue5.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water5", watersetvalue5);
            edit.commit();
            TextView setvaluewater5 = (TextView) findViewById(R.id.setvalueWaterWarning5);
            setvaluewater5.setText(watersetvalue5);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改2#储存罐设定值成功");//设置对话框的标题
            builder.setMessage("修改2#储存罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning6(View view) throws IOException {
        EditText editText6 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning6);
        String watersetvalue6 = editText6.getText().toString();
        if(watersetvalue6.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water6", watersetvalue6);
            edit.commit();
            TextView setvaluewater6 = (TextView) findViewById(R.id.setvalueWaterWarning6);
            setvaluewater6.setText(watersetvalue6);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改3#溶解罐设定值成功");//设置对话框的标题
            builder.setMessage("修改3#溶解罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning7(View view) throws IOException {
        EditText editText7 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning7);
        String watersetvalue7 = editText7.getText().toString();
        if(watersetvalue7.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water7", watersetvalue7);
            edit.commit();
            TextView setvaluewater7 = (TextView) findViewById(R.id.setvalueWaterWarning7);
            setvaluewater7.setText(watersetvalue7);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改4#储存罐设定值成功");//设置对话框的标题
            builder.setMessage("修改4#储存罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
    public void ChangesetvaluesetvalueWaterWarning8(View view) throws IOException {
        EditText editText8 = (EditText) findViewById(R.id.getsetvaluesetvalueWaterWarning8);
        String watersetvalue8 = editText8.getText().toString();
        if(watersetvalue8.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueWater", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Water8", watersetvalue8);
            edit.commit();
            TextView setvaluewater8 = (TextView) findViewById(R.id.setvalueWaterWarning8);
            setvaluewater8.setText(watersetvalue8);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改5#储存罐设定值成功");//设置对话框的标题
            builder.setMessage("修改5#储存罐设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WaterWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
}