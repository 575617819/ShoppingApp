package com.example.administrator.shoppingapp.MyApplication;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/7/17.
 */
public class MyApplication extends Application {

    private SharedPreferences sp;
    private boolean isFirst;

    @Override
    public void onCreate() {
        super.onCreate();

        sp = getSharedPreferences("information", MODE_PRIVATE);
        isFirst = sp.getBoolean("isFirst", true);
    }


    /**
     * setIsFirst
     */
    public void setIsFirst(Boolean isFirst){
        this.isFirst=isFirst;
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isFirst",isFirst);
        edit.commit();
    }

    /**
     * getIsFirst
     * @return
     */
    public boolean getIsFirst(){
        return isFirst;
    }
}
