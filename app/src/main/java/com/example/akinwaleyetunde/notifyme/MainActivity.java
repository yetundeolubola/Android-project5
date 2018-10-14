package com.example.akinwaleyetunde.notifyme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button MyNotify;
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotifyManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        MyNotify = findViewById(R.id.notify);
        MyNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendNotification();

            }
        });
    }
    public void SendNotification() {
        Intent notificationIntent = null;
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setContentIntent(notificationPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_android);


        Notification myNotification = notifyBuilder.build();
        mNotifyManager.notify(NOTIFICATION_ID, myNotification);
        notificationIntent = new Intent(this, MainActivity.class);

    }


}
