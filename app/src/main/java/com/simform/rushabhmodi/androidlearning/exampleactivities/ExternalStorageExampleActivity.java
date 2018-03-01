package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExternalStorageExampleActivity extends AppCompatActivity {

    private Spinner externalSpinner;
    private EditText writeExternal, newFileName;
    private TextView readExternal;

    private File externalStorageFile;
    private String externalData;
    private String externalFileName;
    private List<String> externalFileList;
    ArrayAdapter<String> externalFileAdapter;
    private LayoutInflater newFileLayoutInflater;
    private View newFileView;
    private AlertDialog.Builder newFileDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        externalSpinner = findViewById(R.id.spinner_external_file_name);
        writeExternal = findViewById(R.id.edittext_external_write);
        readExternal = findViewById(R.id.textview_external_read);

        externalFileName = "ExternalStorageFile.txt";

        externalFileList = new ArrayList<>();
        if (externalFileList.isEmpty()){
            externalFileList.add("ExternalStorageFile.txt");
        }
        externalFileList.addAll(Arrays.asList(getFilesDir().list()));

        //externalFileList = getExternalFilesDir(getString(R.string.external_storage_file_path)).list();

        externalFileAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, externalFileList);
        externalFileAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        externalSpinner.setAdapter(externalFileAdapter);

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
        if (!isExternalStorageAvailable()) {
            finish();
            Toast.makeText(this, "External Storage Unavailable", Toast.LENGTH_SHORT).show();
        } else if (isExternalStorageReadOnly()) {
            finish();
            Toast.makeText(this, "External Storage Read-Only", Toast.LENGTH_SHORT).show();
        } else {
            externalStorageFile = new File(getExternalFilesDir(getString(R.string.external_storage_file_path)), externalFileName);
        }
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

    @SuppressLint("InflateParams")
    public void onExternalStorageClick(View view) {
        switch (view.getId()) {
            case R.id.imagebutton_external_add:
                newFileLayoutInflater = LayoutInflater.from(getBaseContext());
                newFileView = newFileLayoutInflater.inflate(R.layout.dialog_add_new_file, null);
                newFileName = newFileView.findViewById(R.id.edittext_dialog_new_file);
                newFileDialogBuilder = new AlertDialog.Builder(this)
                        .setTitle("New File")
                        .setView(newFileView)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                externalFileList.add(newFileName.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                newFileDialogBuilder.show();

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
