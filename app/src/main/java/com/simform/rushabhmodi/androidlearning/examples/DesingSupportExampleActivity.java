package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.pagetransformer.DepthPageTransformer;
import com.simform.rushabhmodi.androidlearning.pagetransformer.NormalPageTransformer;
import com.simform.rushabhmodi.androidlearning.pagetransformer.ZoomOutPageTransformer;
import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.SectionsPagerAdapter;
import com.simform.rushabhmodi.androidlearning.other.BottomNavigationViewBehavior;

public class DesingSupportExampleActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_support_example);

        Toolbar toolbar = findViewById(R.id.toolbar_design_support);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.viewpager_design_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);//to load all the pages together

        TabLayout tabLayout = findViewById(R.id.tablayout_design_support);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        bottomNavigationView = findViewById(R.id.bottomnavigation_design_support);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottomnavigation_item1:
                        mViewPager.setBackgroundColor(getResources().getColor(R.color.viewpager_red));
                        bottomNavigationView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                        return true;
                    case R.id.bottomnavigation_item2:
                        mViewPager.setBackgroundColor(getResources().getColor(R.color.viewpager_green));
                        bottomNavigationView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                        return true;
                    case R.id.bottomnavigation_item3:
                        mViewPager.setBackgroundColor(getResources().getColor(R.color.viewpager_blue));
                        bottomNavigationView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                        return true;
                }
                return false;
            }
        };
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_viewpager_anim, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewpager_normal:
                mViewPager.setPageTransformer(true, new NormalPageTransformer());
                break;
            case R.id.viewpager_zoom:
                mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                break;
            case R.id.viewpager_depth:
                mViewPager.setPageTransformer(true, new DepthPageTransformer());
                break;
            default:
                finish();
        }
        return false;
    }

}
