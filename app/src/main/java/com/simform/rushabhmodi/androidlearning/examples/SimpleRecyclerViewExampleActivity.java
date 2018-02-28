package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.SimpleRecyclerViewAdapter;
import com.simform.rushabhmodi.androidlearning.interfaces.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SimpleRecyclerViewExampleActivity extends AppCompatActivity implements OnRecyclerItemClickListener {

    private RecyclerView simpleRecyclerView;
    private SimpleRecyclerViewAdapter simpleRecyclerViewAdapter;
    private List<String> titleTextList;
    private DividerItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout_recyclerview);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        simpleRecyclerView = findViewById(R.id.recyclerview_base);
        simpleRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        titleTextList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            titleTextList.add("Item " + i);
        }
        simpleRecyclerViewAdapter = new SimpleRecyclerViewAdapter(titleTextList);
        simpleRecyclerViewAdapter.setOnReclyclerItemClickListener(this);
        simpleRecyclerView.setAdapter(simpleRecyclerViewAdapter);
        decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        simpleRecyclerView.addItemDecoration(decoration);
    }

    @Override
    public void onRecyclerItemCLick(View view, int position) {
        Toast.makeText(this, Integer.toString(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycler_change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_recycler_list:
                simpleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_recycler_grid:
                simpleRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            default:
                finish();
        }
        return false;
    }
}
