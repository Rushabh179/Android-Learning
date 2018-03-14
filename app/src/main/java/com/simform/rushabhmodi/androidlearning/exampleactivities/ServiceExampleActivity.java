package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.service.BindedService;
import com.simform.rushabhmodi.androidlearning.service.StartedService;
import com.simform.rushabhmodi.androidlearning.service.BindedService.MyBinder;

public class ServiceExampleActivity extends AppCompatActivity {

    private Intent startedServiceIntent, bindedServiceIntent;

    boolean serviceBound = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        startedServiceIntent = new Intent(this, StartedService.class);
        bindedServiceIntent = new Intent(this, BindedService.class);
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
