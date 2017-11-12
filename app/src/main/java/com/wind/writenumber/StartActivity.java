package com.wind.writenumber;

import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        };
        timer.schedule(timerTask, 2000); //设置2秒后跳转至主界面
    }
}
