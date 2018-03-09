package com.simform.rushabhmodi.androidlearning.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.Toast;

/**
 * Created by rushabh.modi on 09/03/18.
 */

public class BindedService extends Service {

    private IBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Binded", Toast.LENGTH_LONG).show();
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Toast.makeText(this, "Rebinded", Toast.LENGTH_LONG).show();
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Unbinded", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MyBinder extends Binder {
        public BindedService getService() {
            return BindedService.this;
        }
    }
}
