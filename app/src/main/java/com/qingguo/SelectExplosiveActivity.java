package com.qingguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * Created by lyt95 on 2016/12/11.
 */

public class SelectExplosiveActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_explosive);
}
    public void OnClickExplosive(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(SelectExplosiveActivity.this, ExplosiveActivity.class);
        startActivity(intent);
        finish();
    }
}