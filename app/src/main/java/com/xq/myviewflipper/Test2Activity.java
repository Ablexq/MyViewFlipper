package com.xq.myviewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;


public class Test2Activity extends AppCompatActivity implements View.OnTouchListener {
    private ViewFlipper viewFlipper;
    private float startX; //手指按下时的x坐标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initViewFlipper();
    }

    private void initViewFlipper() {
        viewFlipper = (ViewFlipper) findViewById(R.id.vf2);
        viewFlipper.setOnTouchListener(this);
    }


    /**
     * 触摸监听事件
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //手指按下时获取起始点坐标
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起时获取结束点坐标
                float endX = event.getX();
                //比较startX和endX，判断手指的滑动方向
                float moveX = 100f;
                if (endX - startX > moveX) { //手指从左向右滑动
                    viewFlipper.setInAnimation(this, R.anim.left_in);
                    viewFlipper.setOutAnimation(this, R.anim.right_out);
                    viewFlipper.showPrevious();
                } else if (startX - endX > moveX) { //手指向右向左滑动
                    viewFlipper.setInAnimation(this, R.anim.right_in);
                    viewFlipper.setOutAnimation(this, R.anim.left_out);
                    viewFlipper.showNext();
                }
                break;
        }
        return true;
    }

}