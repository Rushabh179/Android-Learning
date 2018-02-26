package com.simform.rushabhmodi.androidlearning.activitymain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

public class HomeScreenActivity extends AppCompatActivity {

    private Intent navigationDrawerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        navigationDrawerIntent = new Intent(this, HomeNavigationActivity.class);
    }

    public void onHomeCardClicked(View view) {
        switch (view.getId()) {
            case R.id.cardview_information:
                navigationDrawerIntent.putExtra(getString(R.string.drawertag), getString(R.string.draweriteminformation));
                startActivity(navigationDrawerIntent);
                break;
            case R.id.cardview_examples:
                navigationDrawerIntent.putExtra(getString(R.string.drawertag), getString(R.string.draweritemexamples));
                startActivity(navigationDrawerIntent);
                break;
            default:
                Toast.makeText(this, R.string.toast_not_ready, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
