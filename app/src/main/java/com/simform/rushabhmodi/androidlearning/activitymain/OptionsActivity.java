package com.simform.rushabhmodi.androidlearning.activitymain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.simform.rushabhmodi.androidlearning.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_options);
    }

    public void onOptionsClick(View view) {
        startActivity(new Intent(getIntent()));
    }
}
