package com.example.mahui.circleview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private LinearLayout linear_layout;

    public static float containerW;
    public static float containerH;

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试画圆的View
        linear_layout = (LinearLayout)findViewById(R.id.linear_layout);

        // **************** ****************8 *****************//
        // 在onCreate方法中获取LinearLayout的宽和高度
        //

        timer = new Timer();
        TimerTask task = new TimerTask(){
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
        timer.schedule(task,10,50);

    }

    final Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1) {
                if(linear_layout.getWidth()!=0) {

                    //获取组件宽度
                    containerW = linear_layout.getMeasuredWidth();
                    containerH = linear_layout.getMeasuredHeight();

                    CircleView circleView = new CircleView(MainActivity.this);
                    linear_layout.addView(circleView);
                    timer.cancel();

                }
            }
        }
    };

}
