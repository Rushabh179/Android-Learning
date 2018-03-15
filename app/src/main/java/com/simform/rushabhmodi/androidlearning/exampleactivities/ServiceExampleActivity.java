package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.service.BindedService;
import com.simform.rushabhmodi.androidlearning.service.BindedService.MyBinder;
import com.simform.rushabhmodi.androidlearning.service.DownloadIntentService;
import com.simform.rushabhmodi.androidlearning.service.JobSchedulerService;
import com.simform.rushabhmodi.androidlearning.service.StartedService;

public class ServiceExampleActivity extends AppCompatActivity {

    private boolean serviceBound = false;
    private Intent startedServiceIntent, bindedServiceIntent, intentServiceIntent;
    private ComponentName jobComponentName;
    private JobInfo jobInfo;
    private JobScheduler jobScheduler;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(DownloadIntentService.FILEPATH);
                int resultCode = bundle.getInt(DownloadIntentService.RESULT);
                if (resultCode == RESULT_OK) {
                    Toast.makeText(ServiceExampleActivity.this,
                            "Download complete. Download URI: " + string,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ServiceExampleActivity.this, "Download failed",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startedServiceIntent = new Intent(this, StartedService.class);
        bindedServiceIntent = new Intent(this, BindedService.class);
        intentServiceIntent = new Intent(this, DownloadIntentService.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(DownloadIntentService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
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
                intentServiceIntent.putExtra(DownloadIntentService.FILENAME, "demofile.txt");
                intentServiceIntent.putExtra(DownloadIntentService.URL, "http://www.sample-videos.com/text/Sample-text-file-10kb.txt");
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
