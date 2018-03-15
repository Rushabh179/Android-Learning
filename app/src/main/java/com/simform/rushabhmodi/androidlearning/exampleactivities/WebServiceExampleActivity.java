package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.simform.rushabhmodi.androidlearning.R;

public class WebServiceExampleActivity extends AppCompatActivity {

    private ListView webServiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_example);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webServiceList = findViewById(R.id.listview_web_service);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }
}
