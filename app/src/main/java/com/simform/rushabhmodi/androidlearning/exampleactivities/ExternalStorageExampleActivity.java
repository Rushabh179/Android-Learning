package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorageExampleActivity extends AppCompatActivity {

    private Spinner externalSpinner;
    private EditText writeExternal;
    private TextView readExternal;

    private File externalStorageFile;
    private String externalData;
    private String externalFileName;
    private String[] externalFileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        externalSpinner = findViewById(R.id.spinner_external_file_name);
        writeExternal = findViewById(R.id.edittext_external_write);
        readExternal = findViewById(R.id.textview_external_read);

        if (!isExternalStorageAvailable()) {
            finish();
            Toast.makeText(this, "External Storage Unavailable", Toast.LENGTH_SHORT).show();
        } else if (isExternalStorageReadOnly()) {
            finish();
            Toast.makeText(this, "External Storage Read-Only", Toast.LENGTH_SHORT).show();
        } else {
            externalStorageFile = new File(getExternalFilesDir(getString(R.string.external_storage_file_path)), getString(R.string.external_storage_file_name));
        }

        externalFileList = getExternalFilesDir(getString(R.string.external_storage_file_path)).list();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, externalFileList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        externalSpinner.setAdapter(adapter);

        externalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                externalFileName = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //Toast.makeText(this, externalStorageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
    }

    private boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);
    }

    private boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

    public void onExternalStorageClick(View view) {
        switch (view.getId()) {
            case R.id.btn_external_write:
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(externalStorageFile);
                    fileOutputStream.write(writeExternal.getText().toString().getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeExternal.setText("");
                break;

            case R.id.btn_external_append:
                try {
                    FileInputStream fileInputStream = new FileInputStream(externalStorageFile);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    String strLine;
                    externalData = "";
                    while ((strLine = bufferedReader.readLine()) != null) {
                        externalData = externalData + strLine;
                    }
                    fileInputStream.close();
                    FileOutputStream fileOutputStream = new FileOutputStream(externalStorageFile);
                    fileOutputStream.write((externalData + writeExternal.getText().toString()).getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeExternal.setText("");
                break;

            case R.id.btn_external_read:
                try {
                    FileInputStream fileInputStream = new FileInputStream(externalStorageFile);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    String strLine;
                    externalData = "";
                    while ((strLine = bufferedReader.readLine()) != null) {
                        externalData = externalData + strLine;
                    }
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                readExternal.setText(externalData);
        }
    }
}
