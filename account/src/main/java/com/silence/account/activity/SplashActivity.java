package com.silence.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.silence.account.R;
import com.silence.account.utils.Constant;

import cn.bmob.v3.BmobUser;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent intent = new Intent();
        // 判斷跳轉哪個頁面
        if (BmobUser.getCurrentUser(this) != null) {
            intent.setClass(this, MainActivity.class);
        } else {
            intent.setClass(this, LoginActivity.class);
        }
        // 延遲一秒載入新頁面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                // 漸變動畫
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, Constant.DELAY_TIME);
    }
}