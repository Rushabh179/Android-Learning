package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.ErvAdapter;

import static com.simform.rushabhmodi.androidlearning.model.ErvDataFactory.makeParents;

/**
 * Visit https://github.com/thoughtbot/expandable-recycler-view/ for more.
 */

public class ExpandableRecyclerViewExampleActivity extends AppCompatActivity {

    private RecyclerView expandableRecyclerView;
    public ErvAdapter ervAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout_recyclerview);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expandableRecyclerView = findViewById(R.id.recyclerview_base);
        expandableRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ervAdapter = new ErvAdapter(makeParents());
        expandableRecyclerView.setAdapter(ervAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

}
