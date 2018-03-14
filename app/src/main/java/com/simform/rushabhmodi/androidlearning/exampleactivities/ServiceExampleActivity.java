package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.service.BindedService;
import com.simform.rushabhmodi.androidlearning.service.DownloadIntentService;
import com.simform.rushabhmodi.androidlearning.service.StartedService;
import com.simform.rushabhmodi.androidlearning.service.BindedService.MyBinder;

public class ServiceExampleActivity extends AppCompatActivity {

    private Intent startedServiceIntent, bindedServiceIntent, intentServiceIntent;
    private boolean serviceBound = false;

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
