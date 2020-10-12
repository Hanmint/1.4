package com.example.ex14.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.ex14.R;
import com.example.ex14.utils.SharedPreferencesUtil;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {

    private static final int HANDLER_MSG_OPEN_NEW=1;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            boolean hadLogin=false;
            if (msg.what==HANDLER_MSG_OPEN_NEW){
                //
                hadLogin = SharedPreferencesUtil.getInstance(splashActivity.this).isLogin();
                Intent intent=null;
                if (hadLogin){
                    //打开列表界面
                    intent = new Intent(splashActivity.this, MainActivity.class);

                }
                else {
                    //打开登录界面
                    intent = new Intent(splashActivity.this, LoginActivity.class);

                }
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(HANDLER_MSG_OPEN_NEW);

            }
        },3000);
    }
}
