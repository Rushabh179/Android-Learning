package com.simform.rushabhmodi.androidlearning.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

/**
 * Created by rushabh.modi on 09/03/18.
 */

public class StartedService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, getString(R.string.service_btn_start), Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, getString(R.string.service_btn_stop), Toast.LENGTH_LONG).show();
    }
}
