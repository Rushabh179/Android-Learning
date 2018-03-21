package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

import com.simform.rushabhmodi.androidlearning.R;

public class TextInputExampleActivity extends BaseExampleActivity {

    private TextInputLayout defaultErrorLayout, customErrorLayout;
    private TextInputEditText defaultErrorText, customErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_example);

        defaultErrorLayout = findViewById(R.id.textInputLayout_error_default);
        customErrorLayout = findViewById(R.id.textInputLayout_error_custom);

        defaultErrorText = findViewById(R.id.textInputEditText_error_default);
        customErrorText = findViewById(R.id.textInputEditText_error_custom);

        defaultErrorText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > defaultErrorLayout.getCounterMaxLength())
                    defaultErrorLayout.setError("Max char. length is " + defaultErrorLayout.getCounterMaxLength());
                else
                    defaultErrorLayout.setError(null);
            }
        });

        customErrorText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > customErrorLayout.getCounterMaxLength())
                    customErrorLayout.setError("Max char. length is " + customErrorLayout.getCounterMaxLength());
                else
                    customErrorLayout.setError(null);
            }
        });
    }

}
