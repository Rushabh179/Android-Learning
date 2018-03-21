package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Bundle;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

public class ScrollViewsExampleActivity extends BaseExampleActivity {

    private TextView nestedScrollTextview, mainScrollTextview, horizontalscrollTextView;
    private String nestedScrollString = "A random NestedScrollView text.\n",
            mainScrollString = "A random simple ScrollView text.\n",
            horizontalscrollString = "A random HorizontalScrollView text. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_views_example);

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

}
