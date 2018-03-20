package com.simform.rushabhmodi.androidlearning.activitymain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {

    private Animation fadeInAnim, elevateAnim;
    private TextView titleTextView;
    private ListView mainScreenListView;
    private ArrayList<String> mainScreenArrayList;
    private ArrayAdapter<String> mainScreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.anim_fadein);
        elevateAnim = AnimationUtils.loadAnimation(this, R.anim.anim_elevate);

        titleTextView = findViewById(R.id.textview_title_main_screen);
        mainScreenListView = findViewById(R.id.listview_main_screen);

        mainScreenArrayList = new ArrayList<>(3);
        mainScreenArrayList.add(getString(R.string.open));
        mainScreenArrayList.add(getString(R.string.options));
        mainScreenArrayList.add(getString(R.string.exit));
        mainScreenAdapter = new ArrayAdapter<>(this, R.layout.list_item_main_screen, mainScreenArrayList);
        mainScreenListView.setAdapter(mainScreenAdapter);

        mainScreenListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainScreenActivity.this, HomeScreenActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        finish();
                        System.exit(0);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        titleTextView.startAnimation(fadeInAnim);
        mainScreenListView.startAnimation(elevateAnim);
    }
}
