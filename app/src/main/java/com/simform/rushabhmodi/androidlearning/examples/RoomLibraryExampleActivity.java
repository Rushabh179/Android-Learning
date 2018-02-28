package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.test.AppDatabase;
import com.simform.rushabhmodi.androidlearning.test.DatabaseInitializer;

public class RoomLibraryExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_room_library_example);
        setContentView(R.layout.base_layout_recyclerview);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_room_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_room_add) {
            DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this));
        } else {
            finish();
        }
        return false;
    }
}
