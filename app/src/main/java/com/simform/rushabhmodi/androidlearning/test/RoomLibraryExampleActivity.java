package com.simform.rushabhmodi.androidlearning.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.test.RoomRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RoomLibraryExampleActivity extends AppCompatActivity {

    private RecyclerView baseRecyclerView;
    private RecyclerView.LayoutManager baseRecyclerLayoutManager;
    private RoomRecyclerAdapter roomRecyclerAdapter;
    private List<String> roomItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_room_library_example);
        setContentView(R.layout.base_layout_recyclerview);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        baseRecyclerView = findViewById(R.id.recyclerview_base);
        baseRecyclerLayoutManager = new LinearLayoutManager(this);
        baseRecyclerView.setLayoutManager(baseRecyclerLayoutManager);

        roomItemList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            roomItemList.add("item" + i);
        }
        roomRecyclerAdapter = new RoomRecyclerAdapter(roomItemList);
        baseRecyclerView.setAdapter(roomRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        //AppDatabase.destroyInstance();
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
            //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this));
        } else {
            finish();
        }
        return false;
    }
}
