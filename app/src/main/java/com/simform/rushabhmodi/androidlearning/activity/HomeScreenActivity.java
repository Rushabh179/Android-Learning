package com.simform.rushabhmodi.androidlearning.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void onHomeCardClicked(View view) {
        switch (view.getId()) {
            case R.id.cardview_examples:
                startActivity(new Intent(getIntent()));
                break;
            default:
                Toast.makeText(this, R.string.toast_not_ready, Toast.LENGTH_SHORT).show();
        }
    }
}
