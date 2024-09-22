package com.example.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Telephony;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "MyChannel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.new_icon, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        Intent iNotify = new Intent(getApplicationContext(), MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, REQUEST_CODE, iNotify, PendingIntent.FLAG_IMMUTABLE);

        //BigPictureStyle
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.new_icon, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Raman")
                .setSummaryText("Image Message");

        //Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("Line 1")
                .addLine("Line 2")
                .addLine("Line 3")
                .addLine("Line 4")
                .addLine("Line 5")
                .addLine("Line 6")
                .addLine("Line 7")
                .addLine("Line 8")
                .addLine("Line 9")
                .addLine("Line 10")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message from Raman");



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)//use png for large icon
                    .setSmallIcon(R.drawable.new_icon)
                    .setContentTitle("My notification")
                    .setContentText("New Message")
                    .setSubText("New Message from Raman")
                    .setContentIntent(pi)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        }else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)//use png for large icon
                    .setSmallIcon(R.drawable.new_icon)
                    .setContentTitle("My notification")
                    .setContentText("New Message")
                    .setAutoCancel(false)
                    .setContentIntent(pi)
                    .setSubText("New Message from Raman")
                    .setStyle(bigPictureStyle)
                    .setOngoing(true)
                    .build();

        }
        nm.notify(NOTIFICATION_ID, notification);




    }
}
