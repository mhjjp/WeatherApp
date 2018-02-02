package com.example.mahui.circleview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



/**
 * Created by mahui on 2018/2/2.
 */

public class CircleView extends View {

    private static String TAG = CircleView.class.getSimpleName();

    //画笔
    private Paint paint;
    private float currentX = 50;
    private float currentY = 50;
    private float radius = 50;

    private Context mContext;
    private float screenW;
    private float screenH;

    public CircleView(Context context) {
        this(context, null);

    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void initPaint(Context context){

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2.0f);

        screenW = MainActivity.containerW;
        screenH = MainActivity.containerH;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制圆
        canvas.drawCircle(currentX, currentY, radius, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        currentY = anayliseY(event.getY());

        currentX = anayliseX(event.getX());


        invalidate();//重新绘制图形
        return true;
    }

    //这里去判断event.getX()的值，如果小于0，就等于0
    private float anayliseX(float x){

        if(x<radius){
            x = radius;
        }

        if(x> screenW - radius){
            x = screenW - radius;
        }
        Log.i(TAG, "anayliseX: x: ="+x);
        return x;
    }

    //这里去判断event.getX()的值，如果小于0，就等于0
    private float anayliseY(float y){

        if(y<radius){
            y = radius;
        }

        if(y> screenH - radius){
            y = screenH - radius;
        }
        Log.i(TAG, "anayliseX: x: ="+y);
        return y;
    }


}
