package com.example.administrator.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ArrayList<View> list=new ArrayList<>();
    int [] image={R.drawable.guide1_vp,R.drawable.guide2_vp,R.drawable.guide3_vp};
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        LayoutInflater layoutInflater = getLayoutInflater();
        for(int x=0;x<image.length;x++){
            View inflate = layoutInflater.inflate(R.layout.guide_item,null);
            ImageView iv_guide_bg = (ImageView) inflate.findViewById(R.id.iv_guide_bg);
            iv_guide_bg.setBackgroundResource(image[x]);//background和src的区别

            if(x==image.length-1){
                Button bt_guide_start = (Button) inflate.findViewById(R.id.bt_guide_start);
                bt_guide_start.setVisibility(View.VISIBLE);
            }

            list.add(inflate);
        }

        viewPager = (ViewPager) findViewById(R.id.vp_guide_bg);
        viewPager.setOffscreenPageLimit(2);//设置预加载页面
        viewPager.setAdapter(new MyViewPager());

    }



    class MyViewPager extends PagerAdapter{


        @Override
        public int getCount() {

            //guide页面的图片数量
            return image.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            //暂时这么写
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //将view添加到viewPager中
            View view = list.get(position);
            viewPager.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

    }


    /**
     * 点击开始体验按钮进入MainActivity
     */
    public void start(View v){
        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
