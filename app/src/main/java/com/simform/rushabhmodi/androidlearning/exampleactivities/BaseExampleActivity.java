package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.R;

/**
 * Created by rushabh.modi on 21/03/18.
 */

public class BaseExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getClass().getSimpleName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
                String toolbarColor = sharedPref.getString(getString(R.string.preference_theme_key), "");
                int colorPrimary = R.color.colorPrimary, colorPrimaryDark = R.color.colorPrimaryDark;

                //Toast.makeText(this, syncConnPref, Toast.LENGTH_SHORT).show();
                switch (toolbarColor) {
                    case "0":
                        colorPrimary = R.color.colorPrimary;
                        colorPrimaryDark = R.color.colorPrimaryDark;
                        break;
                    case "1":
                        colorPrimary = android.R.color.holo_red_light;
                        colorPrimaryDark = android.R.color.holo_red_dark;
                        break;
                    case "2":
                        colorPrimary = android.R.color.holo_green_light;
                        colorPrimaryDark = android.R.color.holo_green_dark;
                        break;
                }

                getSupportActionBar().setBackgroundDrawable(getDrawable(colorPrimary));
                getWindow().setStatusBarColor(getResources().getColor(colorPrimaryDark));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }
}
