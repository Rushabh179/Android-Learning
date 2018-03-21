package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.service.BindedService;
import com.simform.rushabhmodi.androidlearning.service.BindedService.MyBinder;
import com.simform.rushabhmodi.androidlearning.service.DownloadIntentService;
import com.simform.rushabhmodi.androidlearning.service.JobSchedulerService;
import com.simform.rushabhmodi.androidlearning.service.StartedService;

public class ServiceExampleActivity extends BaseExampleActivity {

    private boolean serviceBound = false;
    private Intent startedServiceIntent, bindedServiceIntent, intentServiceIntent;
    private ComponentName jobComponentName;
    private JobInfo jobInfo;
    private JobScheduler jobScheduler;
    private ImageView serviceImageView;
    private IntentResultReceiver intentResultReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        serviceImageView = findViewById(R.id.imageview_service_download);
        intentResultReceiver = new IntentResultReceiver(new Handler());

        startedServiceIntent = new Intent(this, StartedService.class);
        bindedServiceIntent = new Intent(this, BindedService.class);
        intentServiceIntent = new Intent(this, DownloadIntentService.class);
    }

    private class IntentResultReceiver extends ResultReceiver {

        public IntentResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            switch (resultCode) {
                case DownloadIntentService.DOWNLOAD_ERROR:
                    Toast.makeText(getApplicationContext(), "error in download", Toast.LENGTH_SHORT).show();
                    //pd.setVisibility(View.INVISIBLE);
                    break;

                case DownloadIntentService.DOWNLOAD_SUCCESS:
                    String filePath = resultData.getString("filePath");
                    Bitmap bmp = BitmapFactory.decodeFile(filePath);
                    if (serviceImageView != null && bmp != null) {
                        serviceImageView.setImageBitmap(bmp);
                        Toast.makeText(getApplicationContext(), "image download via IntentService is done", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "error in decoding downloaded file", Toast.LENGTH_SHORT).show();
                    }
                    //pd.setIndeterminate(false);
                    //pd.setVisibility(View.INVISIBLE);
                    break;
            }
            super.onReceiveResult(resultCode, resultData);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onServiceClick(View view) {
        switch (view.getId()) {
            case R.id.btn_service_start:
                startService(startedServiceIntent);
                break;

            case R.id.btn_service_stop:
                stopService(startedServiceIntent);
                break;

            case R.id.btn_service_bind:
                startService(bindedServiceIntent);
                bindService(bindedServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btn_service_unbind:
                if (serviceBound) {
                    unbindService(serviceConnection);
                    serviceBound = false;
                }
                stopService(bindedServiceIntent);
                break;

            case R.id.btn_service_intent:
                intentServiceIntent.putExtra(DownloadIntentService.FILENAME, "sdcard/demofile.png");
                intentServiceIntent.putExtra(DownloadIntentService.RECEIVER, intentResultReceiver);
                intentServiceIntent.putExtra(DownloadIntentService.URL, "http://developer.android.com/assets/images/dac_logo.png");
                startService(intentServiceIntent);
                break;

            case R.id.btn_service_job:
                jobComponentName = new ComponentName(this, JobSchedulerService.class);
                jobInfo = new JobInfo.Builder(12, jobComponentName)
                        .setRequiresCharging(true)
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                        .build();
                jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                assert jobScheduler != null;
                int resultCode = jobScheduler.schedule(jobInfo);
                if (resultCode == JobScheduler.RESULT_SUCCESS) {
                    Toast.makeText(this, "Job Scheduled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Job not scheduled", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBinder myBinder = (MyBinder) service;
            myBinder.getService();
            serviceBound = true;
        }
    };
}
