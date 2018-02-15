package com.simform.rushabhmodi.androidlearning.examples;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

public class GestureExampleActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView statusText;
    private GestureDetectorCompat gestureDetector;
    private Button gestureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        statusText = findViewById(R.id.textview_status);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);


        gestureBtn = findViewById(R.id.btn_action);

        gestureBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        statusText.setText(R.string.simpleclick);
                    }
                }
        );

        gestureBtn.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        statusText.setText(R.string.longClick);
                        return true;
                    }
                }
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        statusText.setText(R.string.singletapconfirmed);
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        statusText.setText(R.string.doubletap);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        statusText.setText(R.string.doubletapevent);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        statusText.setText(R.string.down);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        statusText.setText(R.string.showpress);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        statusText.setText(R.string.singletapup);
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        statusText.setText(R.string.scroll);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        statusText.setText(R.string.longpress);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        statusText.setText(R.string.fling);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
