package com.qingguo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

public class ExplosiveWarningActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explosive_warning);
        TextView setvalueExplosive1 = (TextView) findViewById(R.id.setvalueExplosiveWarning1);
        SharedPreferences preference = getSharedPreferences("setValueExplosive", Context.MODE_PRIVATE);
        setvalueExplosive1.setText(preference.getString("Explosive1", String.valueOf(setvalueExplosive1).length() >= 50 ? "无数据" : String.valueOf(setvalueExplosive1)));
//        buttun.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
    public void ChangesetvaluesetvalueExplosiveWarning1(View view) throws IOException {
        EditText editText1 = (EditText) findViewById(R.id.getsetvaluesetvalueExplosiveWarning1);
        String explosivesetvalue1 = editText1.getText().toString();
        if(explosivesetvalue1.length()>1) {

//        int setvalue = Integer.valueOf(editText1.getText().toString()).intValue();
            SharedPreferences preference = getSharedPreferences("setValueExplosive", Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = preference.edit();

            edit.putString("Explosive1", explosivesetvalue1);
            edit.commit();
            TextView setvalueExplosive1 = (TextView) findViewById(R.id.setvalueExplosiveWarning1);
            setvalueExplosive1.setText(explosivesetvalue1);
            android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);
            builder.setTitle("修改15#炸药车设定值成功");//设置对话框的标题
            builder.setMessage("修改15#炸药车设定值成功");//设置对话框的内容
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(ExplosiveWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(ExplosiveWarningActivity.this, "返回", Toast.LENGTH_SHORT).show();

                }
            });
            android.app.AlertDialog b=builder.create();
            b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
        }
    }
}