package com.simform.rushabhmodi.androidlearning.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageExampleActivity extends AppCompatActivity {

    private EditText writeInternal;
    private TextView readInternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_example);

        writeInternal = findViewById(R.id.edittext_internal_write);
        readInternal = findViewById(R.id.textview_internal_read);
    }

    public void onInternalWrite(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(getString(R.string.internal_storage_file_name), MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(writeInternal.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, R.string.internal_storage_toast_save, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeInternal.setText("");
    }

    public void onInternalAppend(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(getString(R.string.internal_storage_file_name), MODE_APPEND);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(writeInternal.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, R.string.internal_storage_toast_save, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeInternal.setText("");
    }

    public void onInternalRead(View view) {
        try {
            FileInputStream fileInputStream = openFileInput(getString(R.string.internal_storage_file_name));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            char[] inputBuffer = new char[100];
            StringBuilder s = new StringBuilder();
            int charRead;

            while ((charRead = inputStreamReader.read(inputBuffer)) > 0) {
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s.append(readstring);
            }
            inputStreamReader.close();
            readInternal.setText(s.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
