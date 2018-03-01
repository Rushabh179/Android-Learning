package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InternalStorageExampleActivity extends AppCompatActivity {

    private Spinner internalSpinner;
    private EditText writeInternal, newFileName;
    private TextView readInternal;
    private FileOutputStream fileOutputStream;
    private OutputStreamWriter outputStreamWriter;
    private String internalFileName;
    private List<String> internalFileList;
    private ArrayAdapter<String> internalFileAdapter;
    private LayoutInflater newFileLayoutInflater;
    private View newFileView;
    private AlertDialog.Builder newFileDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        internalSpinner = findViewById(R.id.spinner_internal_storage);
        writeInternal = findViewById(R.id.edittext_internal_write);
        readInternal = findViewById(R.id.textview_internal_read);

        internalFileList = new ArrayList<>();
        if (internalFileList.isEmpty()){
            internalFileList.add("InternalStorageFile.txt");
        }
        internalFileList.addAll(Arrays.asList(getFilesDir().list()));
        internalFileList.remove("instant-run");//To remove extra file
        internalFileAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, internalFileList);
        internalFileAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        internalSpinner.setAdapter(internalFileAdapter);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//Todo: review
    @SuppressLint("InflateParams")
    public void onInternalStorageClick(View view) {
        switch (view.getId()) {
            case R.id.imagebutton_internal_add:
                newFileLayoutInflater = LayoutInflater.from(getBaseContext());
                newFileView = newFileLayoutInflater.inflate(R.layout.dialog_add_new_file, null);
                newFileName = newFileView.findViewById(R.id.edittext_dialog_new_file);
                newFileDialogBuilder = new AlertDialog.Builder(this)
                        .setTitle("New File")
                        .setView(newFileView)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                internalFileList.add(newFileName.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                newFileDialogBuilder.show();

            case R.id.btn_internal_write:
                try {
                    //fileOutputStream = openFileOutput(getString(R.string.internal_storage_file_name), MODE_PRIVATE);
                    fileOutputStream = openFileOutput(internalFileName, MODE_PRIVATE);
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(writeInternal.getText().toString());
                    outputStreamWriter.close();
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
