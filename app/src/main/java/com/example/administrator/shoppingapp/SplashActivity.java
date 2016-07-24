package com.example.administrator.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.administrator.shoppingapp.MyApplication.MyApplication;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {

                /**
                 * 1.延迟两秒
                 */
                try {
                    Thread.sleep(2000);

                    /**
                     * 如果第一次进入使用应用，跳转到GuideActivity;
                     * 如果不是第一次使用应用，跳转到MainActivity;
                     */
                    MyApplication myApplication = (MyApplication) getApplication();
                    if (myApplication.getIsFirst()) {

                        //设置为false,表示不是第一次进入SplashActivity
                        myApplication.setIsFirst(false);

                        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finish();
            }
        }).start();

    }

    /**
     * 2.SplashActivity按back键没有作用
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
