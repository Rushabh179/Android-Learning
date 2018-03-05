package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.app.Notification;
import android.app.NotificationManager;
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

import com.simform.rushabhmodi.androidlearning.R;

public class NotificationExapleActivity extends AppCompatActivity {

    private NotificationCompat.Builder notificationBuilder;
    private int uniqueID = 0;
    private static final String KEY_TEXT_REPLY = "key_text_reply";

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

        String ANDROID_CHANNEL_ID = "com.simform.rushabhmodi.androidlearning.exampleactivities";
        notificationBuilder = new NotificationCompat.Builder(this, ANDROID_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true);
    }

    public void onNotificationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_notification_simple:
                notificationBuilder
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setTicker("This is the ticker")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setWhen(System.currentTimeMillis())
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("A large text"))
                        .setContentTitle("This is the title")
                        .setContentText("This is the text body of notification")
                        .addAction(android.R.drawable.arrow_up_float, "Open", pendingIntent)
                        .setContentIntent(pendingIntent);

                //Issue notification
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (notificationManager != null) {
                    notificationManager.notify(uniqueID, notificationBuilder.build());
                }
                break;

            case R.id.btn_notification_action:
                // Key for the string that's delivered in the action's intent.
                String replyLabel = "Reply";
                RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                        .setLabel(replyLabel)
                        .build();

                // Build a PendingIntent for the reply action to trigger.
                NotificationCompat.Action action =
                        new NotificationCompat.Action.Builder(android.R.drawable.stat_notify_more,
                                replyLabel, pendingIntent)
                                .addRemoteInput(remoteInput)
                                .build();

                // Build the notification and add the action.
                Notification newMessageNotification = notificationBuilder
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setContentTitle("Action Notification")
                        .setContentText("Content to be showed")
                        .addAction(action)
                        .build();

                // Issue the notification.
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
                notificationManagerCompat.notify(uniqueID, newMessageNotification);
                break;

            case R.id.btn_notification_push:
                startActivity(new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://console.firebase.google.com/project/android-learning-542e7/notification/compose")));
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
