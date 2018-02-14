package com.simform.rushabhmodi.androidlearning.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

public class ScrollViewsExampleActivity extends AppCompatActivity {

    private TextView nestedScrollTextview, mainScrollTextview, horizontalscrollTextView;
    private String nestedScrollString = "A random NestedScrollView text.\n",
            mainScrollString = "A random simple ScrollView text.\n",
            horizontalscrollString = "A random HorizontalScrollView text. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_views_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nestedScrollTextview = findViewById(R.id.textview_scrollview_nested);
        mainScrollTextview = findViewById(R.id.textview_scrollview_main);
        horizontalscrollTextView = findViewById(R.id.textview_scrollview_horizontal);

        for (int i = 0; i <= 30; i++) {
            nestedScrollString += "A random NestedScrollView text.\n";
            mainScrollString += "A random simple ScrollView text.\n";
            horizontalscrollString += "A random HorizontalScrollView text. ";
        }

        nestedScrollTextview.setText(nestedScrollString);
        mainScrollTextview.setText(mainScrollString);
        horizontalscrollTextView.setText(horizontalscrollString);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
