package com.xq.myviewflipper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, Test1Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, Test2Activity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, Test3Activity.class));
                break;   case R.id.btn4:
                startActivity(new Intent(MainActivity.this, Test4Activity.class));
                break;
        }
    }
}
