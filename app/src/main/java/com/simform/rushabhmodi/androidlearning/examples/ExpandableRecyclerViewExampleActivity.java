package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.ErvParentAdapter;

import static com.simform.rushabhmodi.androidlearning.constant.ErvParentDataFactory.makeParents;

/**
 * Visit https://github.com/thoughtbot/expandable-recycler-view/ for more.
 */

public class ExpandableRecyclerViewExampleActivity extends AppCompatActivity {

    private RecyclerView expandableRecyclerView;
    public ErvParentAdapter ervParentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_recycler_view_example);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expandableRecyclerView = findViewById(R.id.recyclerview_expandable);
        expandableRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ervParentAdapter = new ErvParentAdapter(makeParents());
        expandableRecyclerView.setAdapter(ervParentAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
