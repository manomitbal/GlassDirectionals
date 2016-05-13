package com.example.maverick.glassdirectionals;

import android.app.Activity;
import android.gesture.*;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.*;
import android.content.Context;
import android.graphics.*;



public class MainActivity extends Activity {

    int count = -1;
    CustomDrawableView MyView = null;
    public boolean pressed = false;
    private GestureDetector mGestureDetector;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        MyView = new CustomDrawableView(this);
        setContentView(MyView);


    }




    public class CustomDrawableView extends View {

        public CustomDrawableView(Context context) {
            super(context);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float x = getWidth();
            float y = getHeight();

//            int time = (int) (System.currentTimeMillis());

//            if(pressed == true)
//                count++;
            delay(1);
            count++;
            if (count > 4)
                count = 0;
            // Default
            if (count == 0) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(15);
                paint.setColor(Color.parseColor("#9F000F"));
                canvas.drawCircle(x / 2, y / 2, 100, paint);

            }
            //Forward
            else if (count == 1) {

                Paint paint = new Paint();
                Path path = new Path();
                canvas.drawPath(path, paint);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(15);
                paint.setColor(Color.parseColor("#CD5C5C"));
                path.moveTo(x / 2, y / 2 - 100);
                path.lineTo(x / 2 + 100, y / 2);
                path.lineTo(x / 2 - 100, y / 2);
                path.lineTo(x / 2, y / 2 - 100);
                path.moveTo(x / 2 - 50, y / 2);
                path.lineTo(x / 2 - 50, y / 2 + 100);
                path.lineTo(x / 2 + 50, y / 2 + 100);
                path.lineTo(x / 2 + 50, y / 2);
                //path.offset(0, -300);
                canvas.drawPath(path, paint);
            }

            //Backward
            else if (count == 2) {
                Paint paint = new Paint();
                Path path = new Path();
                canvas.drawPath(path, paint);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(15);
                paint.setColor(Color.parseColor("#0000A0"));
                path.moveTo(x / 2, y / 2 + 100);
                path.lineTo(x / 2 + 100, y / 2);
                path.lineTo(x / 2 - 100, y / 2);
                path.lineTo(x / 2, y / 2 + 100);
                path.moveTo(x / 2 - 50, y / 2);
                path.lineTo(x / 2 - 50, y / 2 - 100);
                path.lineTo(x / 2 + 50, y / 2 - 100);
                path.lineTo(x / 2 + 50, y / 2);
                //path.offset(0, 300);
                canvas.drawPath(path, paint);
            }

            //Left
            else if (count == 3) {
                Paint paint = new Paint();
                Path path = new Path();
                canvas.drawPath(path, paint);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(15);
                paint.setColor(Color.parseColor("#808000"));
                path.moveTo(x / 2 - 100, y / 2);
                path.lineTo(x / 2, y / 2 + 100);
                path.lineTo(x / 2, y / 2 - 100);
                path.lineTo(x / 2 - 100, y / 2);
                path.moveTo(x / 2, y / 2 + 50);
                path.lineTo(x / 2 + 100, y / 2 + 50);
                path.lineTo(x / 2 + 100, y / 2 - 50);
                path.lineTo(x / 2, y / 2 - 50);
                //path.offset(-300, 0);
                canvas.drawPath(path, paint);
            }

            //Right
            else if (count == 4) {
                Paint paint = new Paint();
                Path path = new Path();
                canvas.drawPath(path, paint);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(15);
                paint.setColor(Color.parseColor("#EAC117"));
                path.moveTo(x / 2 + 100, y / 2);
                path.lineTo(x / 2, y / 2 - 100);
                path.lineTo(x / 2, y / 2 + 100);
                path.lineTo(x / 2 + 100, y / 2);
                path.moveTo(x / 2, y / 2 - 50);
                path.lineTo(x / 2 - 100, y / 2 - 50);
                path.lineTo(x / 2 - 100, y / 2 + 50);
                path.lineTo(x / 2, y / 2 + 50);
                // path.offset(300, 0);
                canvas.drawPath(path, paint);
            }
        }

        public void delay(int seconds) {
            final int milliseconds = seconds * 1000;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MyView.invalidate();                 //add your code here
                        }
                    }, milliseconds);
                }
            });
        }
        // For Testing Purposes, Iterating through all possible directions based on Screen Clicks
//        @Override
//        public boolean onTouchEvent(MotionEvent event)
//        {
//            switch (event.getAction()){
//                case MotionEvent.ACTION_DOWN:
//                    pressed = true;
//                    invalidate();
//                    break;
//            }
//            return pressed;
//        }

    }


}



