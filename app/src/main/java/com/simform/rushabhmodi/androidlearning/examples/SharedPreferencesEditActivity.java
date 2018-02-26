package com.simform.rushabhmodi.androidlearning.examples;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.simform.rushabhmodi.androidlearning.R;

public class SharedPreferencesEditActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, ageEditText;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_edit);

        firstNameEditText = findViewById(R.id.edittext_sharedpref_first_name);
        lastNameEditText = findViewById(R.id.edittext_sharedpref_last_name);
        ageEditText = findViewById(R.id.edittext_sharedpref_age);

        sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.shared_pref_file_name), MODE_PRIVATE);
        firstNameEditText.setText(sharedPreferences.getString(getString(R.string.shared_pref_first_name), ""));
        lastNameEditText.setText(sharedPreferences.getString(getString(R.string.shared_pref_last_name), ""));
        ageEditText.setText(sharedPreferences.getString(getString(R.string.shared_pref_age), ""));
    }

    public void onSaveClicked(View view) {
        editor = sharedPreferences.edit();
        editor.putString(getString(R.string.shared_pref_first_name), firstNameEditText.getText().toString());
        editor.putString(getString(R.string.shared_pref_last_name), lastNameEditText.getText().toString());
        editor.putString(getString(R.string.shared_pref_age), ageEditText.getText().toString());
        editor.apply();
        onCancelClicked(view);
    }

    public void onCancelClicked(View view) {
        startActivity(new Intent(this, SharedPreferencesExampleActivity.class));
        finish();
        overridePendingTransition(0,0);
    }
}
