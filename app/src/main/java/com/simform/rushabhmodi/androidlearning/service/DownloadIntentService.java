package com.simform.rushabhmodi.androidlearning.service;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rushabh.modi on 14/03/18.
 */

public class DownloadIntentService extends IntentService {

    private int result = Activity.RESULT_CANCELED;
    public static final String URL = "urlpath";
    public static final String FILENAME = "filename";
    public static final String FILEPATH = "filepath";
    public static final String RESULT = "result";
    public static final String NOTIFICATION = "com.simform.rushabhmodi.androidlearning.service";

    public static final String RECEIVER = "receiver";
    public static final int DOWNLOAD_ERROR = 10;
    public static final int DOWNLOAD_SUCCESS = 11;

    public DownloadIntentService() {
        super("DownloadIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Toast.makeText(this, "OnHandle", Toast.LENGTH_LONG).show();
        assert intent != null;
        String urlPath = intent.getStringExtra(URL);
        String fileName = intent.getStringExtra(FILENAME);
        Bundle bundle = new Bundle();

        final ResultReceiver resultReceiver = intent.getParcelableExtra(RECEIVER);
        File downloadFile = new File(fileName);
        if (downloadFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            downloadFile.delete();
        }

        InputStream stream = null;
        FileOutputStream fos = null;
        try {
            downloadFile.createNewFile();
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            fos = new FileOutputStream(downloadFile);

            int next;
            while ((next = reader.read()) != -1) {
                fos.write(next);
            }
            // successfully finished
            //result = Activity.RESULT_OK;
            String filePath = downloadFile.getPath();
            bundle.putString(FILEPATH, filePath);
            resultReceiver.send(DOWNLOAD_SUCCESS, bundle);

        } catch (Exception e) {
            e.printStackTrace();
            resultReceiver.send(DOWNLOAD_ERROR, bundle);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //publishResults(downloadFile.getAbsolutePath(), result);
    }

    private void publishResults(String outputPath, int result) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH, outputPath);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }
}
