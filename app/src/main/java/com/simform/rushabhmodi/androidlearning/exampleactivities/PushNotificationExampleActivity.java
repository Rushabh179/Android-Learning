package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by rushabh.modi on 05/03/18.
 */

public class PushNotificationExampleActivity extends FirebaseMessagingService {

    //private static final String TAG = "FCM Service";
    private NotificationCompat.Builder pushNotificationBuilder;
    private PendingIntent pushPendingIntent;
    private Intent intent;
    private int uniqueID = 99;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        /*Log.d(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getNotification() != null)
            Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());*/

        intent = new Intent(this, NotificationExapleActivity.class);
        pushPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        assert remoteMessage.getNotification() != null;

        String ANDROID_CHANNEL_ID = "com.simform.rushabhmodi.androidlearning.exampleactivities";
        pushNotificationBuilder = new NotificationCompat.Builder(this, ANDROID_CHANNEL_ID);
        pushNotificationBuilder.setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setTicker("This is the ticker")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setWhen(System.currentTimeMillis())
                .setStyle(new NotificationCompat.BigTextStyle().bigText(remoteMessage.getNotification().getBody()))
                .setContentTitle(remoteMessage.getFrom())
                .setContentText(remoteMessage.getNotification().getBody())
                .addAction(android.R.drawable.arrow_up_float, "Open", pushPendingIntent)
                .setContentIntent(pushPendingIntent);

        //Issue notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(uniqueID, pushNotificationBuilder.build());
        }
    }
}
