package com.example.administrator.shoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    /**
     * 连续按两下返回键，退出程序
     */
    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        if(System.currentTimeMillis()-exitTime>2000){
            Toast.makeText(this,"再按一次退出应用",Toast.LENGTH_SHORT).show();
            exitTime=System.currentTimeMillis();
        }else{
            finish();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
