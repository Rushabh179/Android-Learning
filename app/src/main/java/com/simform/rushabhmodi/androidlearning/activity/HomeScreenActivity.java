package com.simform.rushabhmodi.androidlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.constant.FixedVars;

public class HomeScreenActivity extends AppCompatActivity {

    Intent navigationDrawerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        navigationDrawerIntent = new Intent(this, HomeNavigationActivity.class);
        //TranslateAnimation translateAnimation = new TranslateAnimation(100,0,0,0);
    }

    public void onHomeCardClicked(View view) {
        switch (view.getId()) {
            case R.id.cardview_information:
                navigationDrawerIntent.putExtra(FixedVars.DRAWER_TAG, FixedVars.DRAWER_ITEM_INFORMATION);
                startActivity(navigationDrawerIntent);
                break;
            case R.id.cardview_examples:
                navigationDrawerIntent.putExtra(FixedVars.DRAWER_TAG, FixedVars.DRAWER_ITEM_EXAMPLES);
                startActivity(navigationDrawerIntent);
                break;
            default:
                Toast.makeText(this, R.string.toast_not_ready, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
