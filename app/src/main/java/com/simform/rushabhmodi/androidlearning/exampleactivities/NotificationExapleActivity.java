package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.Random;

public class NotificationExapleActivity extends AppCompatActivity {

    private NotificationCompat.Builder defaultNotificationBuilder, actionNotificationBuilder,
            repliedNotificationBuilder, progressNotificationBuilder;
    private NotificationManagerCompat defaultNotificationManager, repliedNotificationManager,
            actionNotificationManager, progressNotificationManager;
    private int uniqueID = 0;

    private Intent intent;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_exaple);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        processReply(intent);
    }

    private void processReply(Intent intent) {
        if (RemoteInput.getResultsFromIntent(intent) != null) {
            Toast.makeText(this, RemoteInput.getResultsFromIntent(intent).getString(getString(R.string.notification_text_key_repy)), Toast.LENGTH_LONG).show();
            repliedNotificationBuilder = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id))
                    .setAutoCancel(true)
                    .setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setContentText("Inline Reply received");

            repliedNotificationManager = NotificationManagerCompat.from(this);
            repliedNotificationManager.notify(100, repliedNotificationBuilder.build());

        }
    }

    public void onNotificationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_notification_simple:
                defaultNotificationBuilder = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id));
                defaultNotificationBuilder
                        .setAutoCancel(true)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setTicker("Default notification ticker")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setWhen(System.currentTimeMillis())
                        .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                        .setContentTitle("Title of the default notification")
                        .setContentText("A simple text body of the default notification")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("A large text to show with notification as an example to understand the use of showing large text in the notification"))
                        .setContentIntent(pendingIntent);
                //Issue notification
                uniqueID = new Random().nextInt(5);
                defaultNotificationManager = NotificationManagerCompat.from(this);
                defaultNotificationManager.notify(uniqueID, defaultNotificationBuilder.build());
                break;

            case R.id.btn_notification_action:
                // Key for the string that's delivered in the action's intent.
                actionNotificationBuilder = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id));
                uniqueID = 100;
                RemoteInput remoteInput = new RemoteInput.Builder(getString(R.string.notification_text_key_repy))
                        .setLabel(getString(R.string.notification_reply_label))
                        .build();
                // Build a PendingIntent for the reply action to trigger.
                NotificationCompat.Action action =
                        new NotificationCompat.Action.Builder(android.R.drawable.stat_notify_more,
                                getString(R.string.notification_reply_label), pendingIntent)
                                .addRemoteInput(remoteInput)
                                .build();
                // Build the notification and add the action.
                actionNotificationBuilder
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setContentTitle("Action Notification title")
                        .setContentText("Content to be showed with actions")
                        .addAction(android.R.drawable.arrow_up_float, "Open", pendingIntent)
                        .addAction(action)
                        .build();
                // Issue the notification.
                actionNotificationManager = NotificationManagerCompat.from(this);
                actionNotificationManager.notify(uniqueID, actionNotificationBuilder.build());
                break;

            case R.id.btn_notification_progress:
                progressNotificationManager = NotificationManagerCompat.from(this);
                progressNotificationBuilder = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id));
                progressNotificationBuilder.setContentTitle("Download")
                        .setContentText("Download in progress")
                        .setSmallIcon(android.R.drawable.stat_sys_download)
                        .setPriority(NotificationCompat.PRIORITY_LOW);
                uniqueID = 50;
                new Thread(new Runnable() {
                    public void run() {
                        // a potentially  time consuming task
                        int incr;
                        // Do the "lengthy" operation 20 times
                        for (incr = 0; incr <= 100; incr += 10) {
                            // Sets the progress indicator to a max value, the current completion percentage, and "determinate" state
                            progressNotificationBuilder.setProgress(100, incr, false);
                            // Displays the progress bar for the first time.
                            progressNotificationManager.notify(uniqueID, progressNotificationBuilder.build());
                            // Sleeps the thread
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        // When the loop is finished, updates the notification
                        progressNotificationBuilder.setContentText("Download complete")
                                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                                .setProgress(0, 0, false);
                        progressNotificationManager.notify(uniqueID, progressNotificationBuilder.build());
                    }
                }).start();
                break;

            case R.id.btn_notification_push:
                startActivity(new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse(getString(R.string.notification_firebase_uri))));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
