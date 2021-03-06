package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.activitymain.HomeScreenActivity;

public class IntentExampleActivity extends BaseExampleActivity {

    private EditText nameEditText, searchEditText;
    private Button explicitIntentBtn, implicitIntentBtn, explicitDataIntentBtn, implicitDataIntentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example);

        String message = getString(R.string.intent_toast_default);
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.intent_toast_name));
        if (name != null) message += " "+name;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        nameEditText = findViewById(R.id.edittext_name_intent);
        searchEditText = findViewById(R.id.edittext_search_intent);

        explicitIntentBtn = findViewById(R.id.btn_explicit_intent);
        implicitIntentBtn = findViewById(R.id.btn_implicit_intent);
        explicitDataIntentBtn = findViewById(R.id.btn_explicit_data_intent);
        implicitDataIntentBtn = findViewById(R.id.btn_implicit_data_intent);

        explicitIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntentExampleActivity.this, HomeScreenActivity.class));
            }
        });

        implicitIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.intent_uri))));
            }
        });

        explicitDataIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getIntent()).putExtra(getString(R.string.intent_toast_name), nameEditText.getText().toString()));
            }
        });

        implicitDataIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_WEB_SEARCH).putExtra(SearchManager.QUERY, searchEditText.getText().toString()));
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}