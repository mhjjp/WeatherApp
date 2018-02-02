package com.example.mahui.circleview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private LinearLayout linear_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConfigUtils.getDeviceWidth(MainActivity.this);
        ConfigUtils.getDeviceHeight(MainActivity.this);

        //测试画圆的View
        linear_layout = (LinearLayout)findViewById(R.id.linear_layout);

        CircleView circleView = new CircleView(MainActivity.this);

        linear_layout.addView(circleView);


    }
}
