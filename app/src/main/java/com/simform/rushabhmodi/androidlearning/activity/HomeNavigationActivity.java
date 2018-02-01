package com.simform.rushabhmodi.androidlearning.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.fragment.InformationFragment;
import com.simform.rushabhmodi.androidlearning.fragment.TestExamplesExpandableFragment;
import com.simform.rushabhmodi.androidlearning.other.FixedVars;

import java.util.Objects;

public class HomeNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (Objects.equals(getIntent().getStringExtra(FixedVars.DRAWER_TAG), FixedVars.DRAWER_ITEM_INFORMATION)) {
            fragmentSetter(new InformationFragment());
        }
        else if (Objects.equals(getIntent().getStringExtra(FixedVars.DRAWER_TAG), FixedVars.DRAWER_ITEM_EXAMPLES)){
            //fragmentSetter(new ExamplesFragment());
            fragmentSetter(new TestExamplesExpandableFragment());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_information) {
            fragmentSetter(new InformationFragment());
        } else if (id == R.id.nav_examples) {
            //fragmentSetter(new ExamplesFragment());
            fragmentSetter(new TestExamplesExpandableFragment());
        } else if (id == R.id.nav_quiz) {
            Toast.makeText(this, R.string.toast_not_ready, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fragmentSetter(Fragment fragmentToLoad){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_main, fragmentToLoad);
        fragmentTransaction.commit();
    }

}