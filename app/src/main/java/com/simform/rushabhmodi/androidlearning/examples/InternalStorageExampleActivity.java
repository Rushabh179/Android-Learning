package com.simform.rushabhmodi.androidlearning.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageExampleActivity extends AppCompatActivity {

    private Spinner internalSpinner;
    private EditText writeInternal;
    private TextView readInternal;
    private FileOutputStream fileOutputStream;
    private OutputStreamWriter outputStreamWriter;

    private String internalFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_example);

        internalSpinner = findViewById(R.id.spinner_internal_storage);
        writeInternal = findViewById(R.id.edittext_internal_write);
        readInternal = findViewById(R.id.textview_internal_read);

        String[] filesList = getFilesDir().list();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        internalSpinner.setAdapter(adapter);

        internalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                internalFileName = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void onInternalStorageClick(View view) {
        switch (view.getId()) {
            case R.id.btn_internal_write:
                try {
                    //fileOutputStream = openFileOutput(getString(R.string.internal_storage_file_name), MODE_PRIVATE);
                    fileOutputStream = openFileOutput(internalFileName, MODE_PRIVATE);
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(writeInternal.getText().toString());
                    outputStreamWriter.close();
                    Toast.makeText(this, R.string.internal_storage_toast_save, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                writeInternal.setText("");
                break;

            case R.id.btn_internal_append:
                try {
                    fileOutputStream = openFileOutput(internalFileName, MODE_APPEND);
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.append(writeInternal.getText().toString());
                    outputStreamWriter.close();
                    Toast.makeText(this, R.string.internal_storage_toast_save, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                writeInternal.setText("");
                break;

            case R.id.btn_internal_read:
                try {
                    FileInputStream fileInputStream = openFileInput(internalFileName);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

                    char[] inputBuffer = new char[100];
                    StringBuilder stringBuilder = new StringBuilder();
                    int charRead;

                    while ((charRead = inputStreamReader.read(inputBuffer)) > 0) {
                        String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                        stringBuilder.append(readstring);
                    }
                    inputStreamReader.close();
                    readInternal.setText(stringBuilder.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
