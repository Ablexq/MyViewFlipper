package com.xq.myviewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;


public class Test3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vf3);
//        viewFlipper.startFlipping();//启动自动播放
        viewFlipper.setAutoStart(true);

        boolean autoStart = viewFlipper.isAutoStart();//是否自动轮播
        System.out.println("autoStart=======" + autoStart);

        viewFlipper.setFlipInterval(3000);//轮播间隔时间
    }


}