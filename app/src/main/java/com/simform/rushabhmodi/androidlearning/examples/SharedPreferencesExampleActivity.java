package com.simform.rushabhmodi.androidlearning.examples;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.activitymain.HomeNavigationActivity;

public class SharedPreferencesExampleActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private TextView firstNameTextView, lastNameTextView, ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstNameTextView = findViewById(R.id.edittext_sharedpref_first_name);
        lastNameTextView = findViewById(R.id.edittext_sharedpref_last_name);
        ageTextView = findViewById(R.id.edittext_sharedpref_age);

        sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.shared_pref_file_name), MODE_PRIVATE);
        firstNameTextView.setText(sharedPreferences.getString(getString(R.string.shared_pref_first_name), ""));
        lastNameTextView.setText(sharedPreferences.getString(getString(R.string.shared_pref_last_name), ""));
        ageTextView.setText(sharedPreferences.getString(getString(R.string.shared_pref_age), ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shared_preferences_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            startActivityForResult(new Intent(this, SharedPreferencesEditActivity.class),1);
            finish();
            overridePendingTransition(0, 0);
            return true;
        } else {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
