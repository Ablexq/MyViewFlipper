package com.xq.myviewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;


public class Test1Activity extends AppCompatActivity implements View.OnTouchListener {
    private ViewFlipper viewFlipper;
    //要添加的页面布局ID
    private int viewIds[] = {R.layout.item_view1, R.layout.item_view2, R.layout.item_view3, R.layout.item_view4};
    private GestureDetector gestureDetector; //创建手势监听器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initViewFlipper();
        addViews();
    }

    private void initViewFlipper() {
        viewFlipper = (ViewFlipper) findViewById(R.id.vf1);
        viewFlipper.setOnTouchListener(this);
        gestureDetector = new GestureDetector(this, new MyGestureListener());
    }

    /**
     * 将页面添加进ViewFlipper
     */
    private void addViews() {
        View itemView;
        for (int viewId : viewIds) {
            itemView = View.inflate(this, viewId, null);
            viewFlipper.addView(itemView);
        }
    }

    /**
     * 自定义手势监听类
     */
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float moveX = 100f;
            if (e2.getX() - e1.getX() > moveX) {
                viewFlipper.setInAnimation(Test1Activity.this, R.anim.left_in);
                viewFlipper.setOutAnimation(Test1Activity.this, R.anim.right_out);
                viewFlipper.showPrevious();
            } else if (e2.getX() - e1.getX() < moveX) {
                viewFlipper.setInAnimation(Test1Activity.this, R.anim.right_in);
                viewFlipper.setOutAnimation(Test1Activity.this, R.anim.left_out);
                viewFlipper.showNext();
            }
            return true;
        }
    }


    /**
     * 触摸监听事件
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
    }

}